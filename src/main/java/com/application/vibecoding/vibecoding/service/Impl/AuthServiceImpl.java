package com.application.vibecoding.vibecoding.service.Impl;

import com.application.vibecoding.vibecoding.dto.auth.AuthResponse;
import com.application.vibecoding.vibecoding.dto.auth.LoginRequest;
import com.application.vibecoding.vibecoding.dto.auth.SignUpRequest;
import com.application.vibecoding.vibecoding.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public AuthResponse signup(SignUpRequest request) {
        return null;
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        return null;
    }
}
