package com.junior.catalogo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.junior.catalogo.dto.ProductDto;
import com.junior.catalogo.entities.Product;
import com.junior.catalogo.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	@Transactional(readOnly = true)
	public Page<ProductDto> findAllPaged(PageRequest pageRequest) {
		Page<Product> list = repository.findAll(pageRequest);
		return list.map(x -> new ProductDto(x));
	}

	@Transactional(readOnly = true)
	public ProductDto findById( Long id) {
		Optional<Product> product = repository.findById(id);
		Product entity = product.get();
		return new ProductDto(entity, entity.getCategory());
	}
	@Transactional(readOnly = true)
	public ProductDto insert(ProductDto dto) {
		Product entity = new Product();
		entity.setName(dto.getName());
		entity.setDate(dto.getDate());
		entity.setDescription(dto.getDescription());
		entity.setPrice(dto.getPrice());
		entity.setImUrl(dto.getImgUrl());
		repository.save(entity);
		return new ProductDto(entity);
	}
	@Transactional(readOnly = true)
	public ProductDto update(Long id, ProductDto dto) {

		@SuppressWarnings("deprecation")
		Product entity = repository.getOne(id);
		entity.setName(dto.getName());
		repository.save(entity);
		return new ProductDto(entity);
	}

	public void delete(Long id) {

		repository.deleteById(id);
	}

}
