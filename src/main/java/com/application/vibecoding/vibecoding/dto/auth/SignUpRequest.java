package com.application.vibecoding.vibecoding.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SignUpRequest(
        @Email @NotBlank String username,
        @Size(min = 4, max = 50) String name,
        @Size(min = 4, max = 15) String password
) {
}
