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
		Category cat3 = new Category(null, "Computers");
		Category cat4 = new Category(null, "Books");
		Category cat5 = new Category(null, "Eletronics");
		Category cat6 = new Category(null, "Computers");
		Category cat7 = new Category(null, "Books");
		Category cat8 = new Category(null, "Eletronics");
		Category cat9 = new Category(null, "Computers");
		Category cat10 = new Category(null, "Books");
		Category cat11 = new Category(null, "Eletronics");
		Category cat12 = new Category(null, "Computers");
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8, cat9, cat10, cat11, cat12));
		
	}



}
