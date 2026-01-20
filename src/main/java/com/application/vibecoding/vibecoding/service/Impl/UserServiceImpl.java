package com.application.vibecoding.vibecoding.service.Impl;

import com.application.vibecoding.vibecoding.dto.auth.UserProfileResponse;
import com.application.vibecoding.vibecoding.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserProfileResponse getProfile(Long userId) {
        return null;
    }
}
