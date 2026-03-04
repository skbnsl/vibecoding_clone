package com.application.vibecoding.vibecoding.dto.member;

import com.application.vibecoding.vibecoding.enums.ProjectRole;

import java.time.Instant;

public record MemberResponse(
        Long userId,
        String username,
        String name,
        String avatarUrl,
        ProjectRole projectRole,
        Instant invitedAt
) {
}
