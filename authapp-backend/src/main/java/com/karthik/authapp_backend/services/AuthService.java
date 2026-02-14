package com.karthik.authapp_backend.services;

import com.karthik.authapp_backend.dtos.UserDto;

public interface AuthService {

	UserDto registerUser(UserDto userDto);
}
