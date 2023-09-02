package com.junior.catalogo.dto;

import java.util.Set;

import com.junior.catalogo.entities.Role;

public record RegisterDto(String login, String password, Set<Role>roles) {

}
