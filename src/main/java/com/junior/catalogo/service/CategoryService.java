package com.junior.catalogo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junior.catalogo.entities.Category;
import com.junior.catalogo.repository.CategoryRepository;
@Service
public class CategoryService {
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		return repository.findAll();
	}

}
