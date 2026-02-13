package com.karthik.authapp_backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	//api/v1/users
	@PostMapping
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userDto));
	}
	
	//get all user api
	//api/v1/users
	@GetMapping
	public ResponseEntity<Iterable<UserDto>> getAllUsers(){
		return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
	}
	
	//get user by email
	//api/v1/users/email/{email}
	@GetMapping("/email/{email}")
	public ResponseEntity<UserDto> getUserByEmail(@PathVariable String email){
		return ResponseEntity.status(HttpStatus.OK).body(userService.getUserByEmail(email));
	}
	
	//get user by id
	//api/v1/users/{id}
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable String id){
		return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
	}
	
	//delete user
	//api/v1/users/{id}
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable String userId) {
		userService.deleteUser(userId);
	}
	
	//updateUser
	//api/v1/users/{id}
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable("userId") String userId){
		return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(userDto, userId));
	}
}
