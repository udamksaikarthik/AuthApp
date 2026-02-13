package com.karthik.authapp_backend.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karthik.authapp_backend.entities.User;

public interface UserRepository extends JpaRepository<User, UUID>{
	
	Optional<User> findByEmail(String email);
	boolean existsByEmail(String email);

}
