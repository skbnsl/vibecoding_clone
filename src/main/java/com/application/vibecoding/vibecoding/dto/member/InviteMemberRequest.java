package com.application.vibecoding.vibecoding.dto.member;

import com.application.vibecoding.vibecoding.enums.ProjectRole;

public record InviteMemberRequest(
        String email,
        ProjectRole role
) {
}
