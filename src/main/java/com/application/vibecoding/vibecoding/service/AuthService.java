package com.application.vibecoding.vibecoding.service;

import com.application.vibecoding.vibecoding.dto.auth.AuthResponse;
import com.application.vibecoding.vibecoding.dto.auth.LoginRequest;
import com.application.vibecoding.vibecoding.dto.auth.SignUpRequest;
import org.jspecify.annotations.Nullable;

public interface AuthService {
    AuthResponse signup(SignUpRequest request);

    AuthResponse login(LoginRequest request);
}
