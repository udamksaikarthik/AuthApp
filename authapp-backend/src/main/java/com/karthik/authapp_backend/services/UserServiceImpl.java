package com.karthik.authapp_backend.services;

import java.time.Instant;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karthik.authapp_backend.dtos.UserDto;
import com.karthik.authapp_backend.entities.Provider;
import com.karthik.authapp_backend.entities.User;
import com.karthik.authapp_backend.exceptions.ResourceNotFoundException;
import com.karthik.authapp_backend.helpers.UserHelper;
import com.karthik.authapp_backend.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		
		if(userDto.getEmail()==null || userDto.getEmail().isBlank()) {
			throw new IllegalArgumentException("Email is required");
		}
		
		if(userRepository.existsByEmail(userDto.getEmail())) {
			throw new IllegalArgumentException("User with given email already exists");
		}
		
		//if we need extra checks we can do them here...
		
		User user = modelMapper.map(userDto, User.class);
		
		user.setProvider(userDto.getProvider()!=null ? userDto.getProvider() : Provider.LOCAL);
		
		// role assign we can implement here based on requirement...
		
		User savedUser = userRepository.save(user); //save the user to DB
		
		return modelMapper.map(savedUser,  UserDto.class);
	}

	@Override
	public UserDto getUserByEmail(String email) {
		
		User user = userRepository
				.findByEmail(email)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with given email"));
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public UserDto updateUser(UserDto userDto, String userId) {
		UUID uid = UserHelper.parseUUID(userId);
		User existingUser = userRepository
				.findById(uid).orElseThrow(() -> new ResourceNotFoundException("User not found with given id."));
		if(userDto.getName()!=null) existingUser.setName(userDto.getName());
		existingUser.setEnabled(userDto.isEnabled());
		if(userDto.getPassword()!=null) existingUser.setPassword(userDto.getPassword());
		if(userDto.getProvider()!=null) existingUser.setProvider(userDto.getProvider());
		existingUser.setUpdatedAt(Instant.now());
		
		User savedUser = userRepository.save(existingUser);
		
		return modelMapper.map(savedUser, UserDto.class);
	}

	@Override
	public void deleteUser(String userId) {
		UUID uid = UserHelper.parseUUID(userId);
		User user = userRepository.findById(uid)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with given ID"));
		userRepository.delete(user);
	}

	@Override
	public UserDto getUserById(String userId) {
		UUID uid = UserHelper.parseUUID(userId);
		User user = userRepository.findById(uid)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with given Id"));
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public Iterable<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository
				.findAll()
				.stream()
				.map(user -> modelMapper.map(user, UserDto.class))
				.toList();
	}

}
