package com.eiasinprodhan.auth.controller;

import com.eiasinprodhan.auth.dto.request.LoginRequest;
import com.eiasinprodhan.auth.dto.request.UserRequest;
import com.eiasinprodhan.auth.dto.response.JwtTokenResponse;
import com.eiasinprodhan.auth.dto.response.UserResponse;
import com.eiasinprodhan.auth.service.UserService;
import lombok.RequiredArgsConstructor;
import com.eiasinprodhan.auth.exception.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserRestController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/register-user")
    public ResponseEntity<UserResponse> saveUser(@RequestBody UserRequest userRequest) {
        UserResponse userResponse = userService.saveUser(userRequest);
        return new  ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

    @PostMapping("/generate-token")
    public JwtTokenResponse generateToken(@RequestBody LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate((new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())));

            if(authentication.isAuthenticated()){
                return userService.generateToken(loginRequest.getUsername());
            }else {
                throw new BadRequestException("Invalid Credential.");
            }
    }catch (Exception e){
        throw new BadRequestException("Invalid Credential.");}
    }
}
