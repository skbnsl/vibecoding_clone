package com.application.vibecoding.vibecoding.dto.member;

import com.application.vibecoding.vibecoding.enums.ProjectRole;
import jakarta.validation.constraints.NotNull;

public record UpdateMemberRoleRequest(@NotNull ProjectRole role) {

}
