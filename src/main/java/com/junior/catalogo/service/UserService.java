package com.junior.catalogo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.junior.catalogo.dto.RoleDto;
import com.junior.catalogo.dto.UserDto;
import com.junior.catalogo.dto.UserInsertDto;

import com.junior.catalogo.entities.Role;
import com.junior.catalogo.entities.User;
import com.junior.catalogo.repository.RoleRepository;
import com.junior.catalogo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository; 
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Transactional(readOnly = true)
	public Page<UserDto> findAllPaged(PageRequest pageRequest){
		Page<User> list =  repository.findAll(pageRequest);
		return list.map(x -> new UserDto(x));
	}
	
	public UserDto findById(Long id) {
		Optional<User> user = repository.findById(id);
		User entity =  user.get();
		return new UserDto(entity);
	}
	public UserDto insert(UserInsertDto dto) {
		User entity = new User();
		copyDtoToEntity(dto, entity);
		entity.setPassword(passwordEncoder.encode(dto.getPassword()));
		entity = repository.save(entity);
		return new UserDto(entity);
	}

	@SuppressWarnings("deprecation")
	private void copyDtoToEntity(UserDto dto, User entity) {
		entity.setFirstName(dto.getFirstName());
		entity.setEmail(dto.getEmail());
		entity.setLastName(dto.getLastName());
		
		entity.getRoles().clear();
		for(RoleDto roleDto: dto.getRoles()) {
			Role role = roleRepository.getOne(roleDto.getId());
			entity.getRoles().add(role);
		}
		
	}
	@Transactional(readOnly = true)
	public UserDto update(Long id, UserDto dto) {

		@SuppressWarnings("deprecation")
		User entity = repository.getOne(id);
		entity.setFirstName(dto.getFirstName());
		repository.save(entity);
		return new UserDto(entity);
	}

	public void delete(Long id) {

		repository.deleteById(id);
	}
	
}
