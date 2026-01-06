package com.application.vibecoding.vibecoding.dto.auth;

public record SignUpRequest(
        String email,
        String name,
        String password
) {
}
