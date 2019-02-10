package com.canuto.cursomc;

import com.canuto.cursomc.domain.Categoria;
import com.canuto.cursomc.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private final CategoriaRepository categoriaRepository;

	@Autowired
	public Application(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "cat 2");

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
	}
}

