package com.junior.catalogo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
