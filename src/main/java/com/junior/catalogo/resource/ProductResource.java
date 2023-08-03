package com.junior.catalogo.resource;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.junior.catalogo.dto.ProductDto;
import com.junior.catalogo.service.ProductService;

@RestController
@RequestMapping(value= "/products")
public class ProductResource {
	@Autowired
	private ProductService service;
	@GetMapping
	public ResponseEntity <Page<ProductDto>> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy){
			PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
			
		Page<ProductDto> product= service.findAllPaged(pageRequest);
		return ResponseEntity.ok().body(product);
	}
	@GetMapping(value="/{id}")
	public ResponseEntity<ProductDto> findById(@PathVariable Long id){
		ProductDto product = service.findById(id);
		return ResponseEntity.ok().body(product);
	}
	
	@PostMapping
	public ResponseEntity<ProductDto> insert(@RequestBody ProductDto dto){
		ProductDto entity = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(entity);
	}
	@PutMapping
	public ResponseEntity<ProductDto> update(@PathVariable Long id, @RequestBody ProductDto dto){
		ProductDto entity = service.update(id, dto);
		return ResponseEntity.ok().body(entity);
	}
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
