package com.application.vibecoding.vibecoding.mapper;

import com.application.vibecoding.vibecoding.dto.auth.SignUpRequest;
import com.application.vibecoding.vibecoding.dto.auth.UserProfileResponse;
import com.application.vibecoding.vibecoding.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(SignUpRequest signUpRequest);

    UserProfileResponse toUserProfileResponse(User user);
}
