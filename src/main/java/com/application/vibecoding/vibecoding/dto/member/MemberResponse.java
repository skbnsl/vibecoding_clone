package com.application.vibecoding.vibecoding.dto.member;

import com.application.vibecoding.vibecoding.enums.ProjectRole;

import java.time.Instant;

public record MemberResponse(
        Long userId,
        String email,
        String name,
        String avatarUrl,
        ProjectRole role,
        Instant invitedAt
) {
}
