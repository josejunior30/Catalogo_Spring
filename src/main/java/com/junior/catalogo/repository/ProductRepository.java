package com.junior.catalogo.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.junior.catalogo.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	

}
