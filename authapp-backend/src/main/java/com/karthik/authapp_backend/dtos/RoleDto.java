package com.karthik.authapp_backend.dtos;

import java.util.UUID;


public class RoleDto {
	private UUID id = UUID.randomUUID();
	private String name;
	
	public RoleDto() {
		
	}
	
	public RoleDto(UUID id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "RoleDto [id=" + id + ", name=" + name + "]";
	}

	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
