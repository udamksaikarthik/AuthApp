package com.karthik.authapp_backend.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karthik.authapp_backend.dtos.UserDto;
import com.karthik.authapp_backend.entities.Provider;
import com.karthik.authapp_backend.entities.User;
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
			throw new IllegalArgumentException("Email already exists");
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto updateUser(UserDto userDto, String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(String userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserDto getUserById(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
