package com.karthik.authapp_backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.karthik.authapp_backend.dtos.UserDto;

@Service
public class AuthServiceImpl implements AuthService{

	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDto registerUser(UserDto userDto) {
		//logic
		//verify email
		//verify password
		//default roles
		userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
		UserDto registeredUser = userService.createUser(userDto);
		
		return registeredUser;
	}

}
