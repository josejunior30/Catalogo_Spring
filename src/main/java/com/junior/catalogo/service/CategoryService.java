package com.junior.catalogo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
	public Page<CategoryDto> findAllPaged(PageRequest pageRequest) {
		Page<Category> list = repository.findAll(pageRequest);
		return list.map(x -> new CategoryDto(x));
	}

	@Transactional(readOnly = true)
	public CategoryDto findById(Long id) {
		Optional<Category> category = repository.findById(id);
		Category entity = category.get();
		return new CategoryDto(entity);
	}

	@Transactional(readOnly = true)
	public CategoryDto insert(CategoryDto dto) {
		Category entity = new Category();
		entity.setName(dto.getName());
		repository.save(entity);
		return new CategoryDto(entity);
	}

	@SuppressWarnings("deprecation")
	@Transactional
	public CategoryDto update(Long id, CategoryDto dto) {
	
		Category entity = repository.getOne(id);
		entity.setName(dto.getName());
		entity= repository.save(entity);
		return new CategoryDto(entity);
}
	
	public  void  delete(Long id) {
		
		repository.deleteById(id);
	}
}