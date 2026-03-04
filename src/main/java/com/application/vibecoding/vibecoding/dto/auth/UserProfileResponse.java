package com.application.vibecoding.vibecoding.dto.auth;

public record UserProfileResponse(
        Long id,
        String username,
        String name
) {
}
