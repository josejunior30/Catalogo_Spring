package com.junior.catalogo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junior.catalogo.dto.CategoryDto;
import com.junior.catalogo.entities.Category;
import com.junior.catalogo.repository.CategoryRepository;
@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	@Transactional(readOnly = true)
	public List<CategoryDto> findAll(){
		List<Category>list =repository.findAll();
		
		List<CategoryDto>listDto =  new ArrayList<>();
		for(Category cat: list) {
			listDto.add(new CategoryDto(cat));
		}
		return listDto;
	}

}
