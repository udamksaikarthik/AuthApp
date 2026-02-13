package com.karthik.authapp_backend.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.karthik.authapp_backend.dtos.UserDto;
import com.karthik.authapp_backend.services.UserService;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
	
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userDto));
	}
}
