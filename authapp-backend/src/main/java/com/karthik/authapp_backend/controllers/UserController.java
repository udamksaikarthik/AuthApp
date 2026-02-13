package com.karthik.authapp_backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.karthik.authapp_backend.dtos.UserDto;
import com.karthik.authapp_backend.services.UserService;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//create user api
	@PostMapping
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userDto));
	}
	
	//get all user api
	@GetMapping
	public ResponseEntity<Iterable<UserDto>> getAllUsers(){
		return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
	}
}
