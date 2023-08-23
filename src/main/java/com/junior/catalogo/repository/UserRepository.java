package com.junior.catalogo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.junior.catalogo.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByEmail(String email);

}
