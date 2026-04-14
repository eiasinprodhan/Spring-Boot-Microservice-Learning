package com.eiasinprodhan.auth.service;

import com.eiasinprodhan.auth.dto.request.UserRequest;
import com.eiasinprodhan.auth.dto.response.JwtTokenResponse;
import com.eiasinprodhan.auth.dto.response.UserResponse;
import com.eiasinprodhan.auth.entity.User;
import com.eiasinprodhan.auth.repository.UserRepository;
import com.eiasinprodhan.auth.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final JwtUtil jwtUtil;


    @Override
    public UserResponse saveUser(UserRequest userRequest) {

        User user = modelMapper.map(userRequest, User.class);

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        UserResponse userResponse = modelMapper.map(userRepository.save(user), UserResponse.class);

        return userResponse;
    }

    @Override
    public JwtTokenResponse generateToken(String username) {
        String token = jwtUtil.generateToken(username);
        JwtTokenResponse jwtTokenResponse = new JwtTokenResponse();
        jwtTokenResponse.setToken(token);
        jwtTokenResponse.setTokenType("Bearer");
        jwtTokenResponse.setValidity(jwtUtil.extractExpiration(token).toString());
        return jwtTokenResponse;
    }
}
