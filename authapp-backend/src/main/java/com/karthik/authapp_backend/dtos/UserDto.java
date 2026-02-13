package com.karthik.authapp_backend.dtos;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.karthik.authapp_backend.entities.Provider;
import com.karthik.authapp_backend.entities.Role;


public class UserDto {

	private UUID id;
	private String email;
	private String name;
	private String password;
	private boolean enabled = true;
	private Instant createdAt = Instant.now();
	private Instant updatedAt = Instant.now();
	private Provider provider = Provider.LOCAL;
	private Set<Role> roles = new HashSet<>();
	
	public UserDto() {
		
	}
	
	public UserDto(UUID id, String email, String name, String password, boolean enabled, Instant createdAt,
			Instant updatedAt, Provider provider, Set<Role> roles) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.password = password;
		this.enabled = enabled;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.provider = provider;
		this.roles = roles;
	}
	
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", email=" + email + ", name=" + name + ", password=" + password + ", enabled="
				+ enabled + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", provider=" + provider
				+ ", roles=" + roles + "]";
	}

	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public Instant getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}
	public Instant getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Instant updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Provider getProvider() {
		return provider;
	}
	public void setProvider(Provider provider) {
		this.provider = provider;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
}
