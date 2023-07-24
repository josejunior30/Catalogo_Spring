package com.junior.catalogo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.junior.catalogo.entities.Category;
import com.junior.catalogo.repository.CategoryRepository;

@Configuration
@Profile("test")
public class testConfig implements CommandLineRunner{
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Books");
		Category cat2 = new Category(null, "Eletronics");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		
	}



}
