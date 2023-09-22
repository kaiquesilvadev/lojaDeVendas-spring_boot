package com.kaique.projetoLoja.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.kaique.projetoLoja.domain.Categoria;
import com.kaique.projetoLoja.repositories.CategoriaRepository;

@Configuration
public class Testconfig implements CommandLineRunner{

	@Autowired
	private CategoriaRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		Categoria p1 = new  Categoria(null , "blusa"); // apenas um teste que serar apagano 
		Categoria p2 = new  Categoria(null , "camisa");// apenas um teste que serar apagano 
		
		repository.saveAll(Arrays.asList(p1 , p2 ));
	}

}
