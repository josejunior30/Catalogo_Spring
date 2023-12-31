package com.junior.catalogo.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.junior.catalogo.entities.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
    @NotBlank(message="Campo obrigatorio")
	private String firstName;
	private String lastName;
	@Email(message="colocar em-mail valido")
	private String email;
	
	
	private Set<RoleDto> roles = new HashSet<>();
	
	public UserDto() {
		
	}
	
	public UserDto(Long id, String firstName, String lastName, String email) {
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	
	}
	public UserDto(User entity) {
	
		id = entity.getId();
		firstName = entity.getFirstName();
		lastName = entity.getLastName();
		email = entity.getEmail();
		entity.getRoles().forEach(role-> this.roles.add(new RoleDto(role)));
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public Set<RoleDto> getRoles() {
		return roles;
	}

	
}
