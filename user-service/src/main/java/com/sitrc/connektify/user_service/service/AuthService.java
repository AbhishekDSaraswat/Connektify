package com.sitrc.connektify.user_service.service;

import com.sitrc.connektify.user_service.dto.LoginRequestDto;
import com.sitrc.connektify.user_service.dto.SignupRequestDto;
import com.sitrc.connektify.user_service.dto.UserDto;

public interface AuthService {

    UserDto signUp(SignupRequestDto signupRequestDto);

    String login(LoginRequestDto loginRequestDto);
}
