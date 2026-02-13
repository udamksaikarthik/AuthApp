package com.karthik.authapp_backend.services;

import com.karthik.authapp_backend.dtos.UserDto;

public interface UserService {

	//create user
	UserDto createUser(UserDto userDto);
	
	//get user by email
	UserDto getUserByEmail(String email);
	
	//update user
	UserDto updateUser(UserDto userDto, String userId);
	
	//delete user
	void deleteUser(String userId);
	
	//get user by id
	UserDto getUserById(String userId);
	
	//get All Users
	Iterable<UserDto> getAllUsers();
}
