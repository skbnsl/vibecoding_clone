package com.application.vibecoding.vibecoding.service;

import com.application.vibecoding.vibecoding.dto.auth.UserProfileResponse;
import org.jspecify.annotations.Nullable;

public interface UserService {
    UserProfileResponse getProfile(Long userId);
}
