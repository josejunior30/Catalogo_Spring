package com.junior.catalogo.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.junior.catalogo.dto.CategoryDto;

import com.junior.catalogo.service.CategoryService;
@RestController
@RequestMapping(value="/categories")
public class CategoryResource {
	@Autowired
	private CategoryService service;
	
	@GetMapping
	public ResponseEntity<List<CategoryDto>> findAll() {
		List<CategoryDto> category = service.findAll();
		return ResponseEntity.ok().body(category);
	}
	@GetMapping(value= "/{id}")
	public ResponseEntity<CategoryDto> findById(@PathVariable Long id){
		CategoryDto category = service.findById(id);
		return ResponseEntity.ok().body(category);
	}
	@PostMapping
	public ResponseEntity<CategoryDto> insert(@RequestBody CategoryDto dto){
		CategoryDto entity = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(entity);
	}
	@PutMapping(value="/{id}")
	public ResponseEntity<CategoryDto>update(@PathVariable Long id,@RequestBody CategoryDto dto){
		CategoryDto entity = service.update(id, dto);
		return ResponseEntity.ok().body(entity);
				
	}
}
