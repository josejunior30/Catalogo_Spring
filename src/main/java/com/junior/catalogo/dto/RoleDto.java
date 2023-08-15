package com.junior.catalogo.dto;

import java.io.Serializable;

import com.junior.catalogo.entities.Role;

public class RoleDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	Long id;
	String authority;
	
	public RoleDto() {
		
	}
	public RoleDto(Long id, String authority) {
		super();
		this.id = id;
		this.authority = authority;
	}
	
	public RoleDto(Role role) {
		
		id = role.getId();
		authority = role.getAuthority();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	 
}

