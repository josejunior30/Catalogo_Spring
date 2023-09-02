package com.junior.catalogo.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.junior.catalogo.dto.AuthenticationDto;
import com.junior.catalogo.dto.RegisterDto;
import com.junior.catalogo.entities.User;
import com.junior.catalogo.repository.UserRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserRepository repository;

	
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody @Valid AuthenticationDto data) {
	var userNamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
	var auth = this.authenticationManager.authenticate(userNamePassword);
	return ResponseEntity.ok().build();
	}
		
	@PostMapping("/register")
	public ResponseEntity register(@RequestBody @Valid RegisterDto data) {
		if(this.repository.findByEmail(data.login()) !=null)return  ResponseEntity.badRequest().build();
	
		String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
	User newUser= new User(data.login(),encryptedPassword, data.roles());
	this.repository.save(newUser);
	
	return ResponseEntity.ok().build();
	}
}

