package com.application.vibecoding.vibecoding.service.Impl;

import com.application.vibecoding.vibecoding.dto.auth.AuthResponse;
import com.application.vibecoding.vibecoding.dto.auth.LoginRequest;
import com.application.vibecoding.vibecoding.dto.auth.SignUpRequest;
import com.application.vibecoding.vibecoding.entity.User;
import com.application.vibecoding.vibecoding.error.BadRequestException;
import com.application.vibecoding.vibecoding.mapper.UserMapper;
import com.application.vibecoding.vibecoding.repository.UserRepository;
import com.application.vibecoding.vibecoding.service.AuthService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthServiceImpl implements AuthService {

    UserRepository userRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse signup(SignUpRequest request) {
        userRepository.findByUsername(request.username()).ifPresent(user -> {
            throw new BadRequestException("user already exist with username: "+request.username());
        });

        User user = userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(request.password()));

        userRepository.save(user);

        return new AuthResponse("dummy token",userMapper.toUserProfileResponse(user));
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        return null;
    }
}
