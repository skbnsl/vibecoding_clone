package com.application.vibecoding.vibecoding.controller;

import com.application.vibecoding.vibecoding.dto.auth.AuthResponse;
import com.application.vibecoding.vibecoding.dto.auth.LoginRequest;
import com.application.vibecoding.vibecoding.dto.auth.SignUpRequest;
import com.application.vibecoding.vibecoding.dto.auth.UserProfileResponse;
import com.application.vibecoding.vibecoding.service.AuthService;
import com.application.vibecoding.vibecoding.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signup(SignUpRequest request){
        return ResponseEntity.ok(authService.signup(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> signup(LoginRequest request){
        return ResponseEntity.ok(authService.login(request));
    }

    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> getProfile(){
        Long userId = 1L;
        return ResponseEntity.ok(userService.getProfile(userId));
    }

}
