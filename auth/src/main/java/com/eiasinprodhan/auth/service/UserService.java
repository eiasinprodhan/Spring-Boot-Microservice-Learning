package com.eiasinprodhan.auth.service;

import com.eiasinprodhan.auth.dto.request.UserRequest;
import com.eiasinprodhan.auth.dto.response.JwtTokenResponse;
import com.eiasinprodhan.auth.dto.response.UserResponse;

public interface UserService {
    public UserResponse saveUser(UserRequest userRequest);
    public JwtTokenResponse generateToken(String username) ;

}
