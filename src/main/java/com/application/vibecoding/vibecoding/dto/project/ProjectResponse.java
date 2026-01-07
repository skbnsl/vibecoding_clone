package com.application.vibecoding.vibecoding.dto.project;

import com.application.vibecoding.vibecoding.dto.auth.UserProfileResponse;

import java.time.Instant;

public record ProjectResponse(
        Long id,
        String name,
        Instant createdAt,
        Instant updatedAt,
        UserProfileResponse owner
) {
}
