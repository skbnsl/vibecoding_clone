package com.application.vibecoding.vibecoding.dto.auth;

public record LoginRequest(
        String email,
        String password
) {
}
