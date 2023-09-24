package com.kaique.projetoLoja.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.kaique.projetoLoja.domain.Categoria;
import com.kaique.projetoLoja.domain.Produto;
import com.kaique.projetoLoja.repositories.CategoriaRepository;
import com.kaique.projetoLoja.repositories.ProdutoRepository;

@Configuration
public class Testconfig implements CommandLineRunner {

	@Autowired
	private CategoriaRepository repository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	public void run(String... args) throws Exception {
		Categoria p1 = new Categoria(null, "escritorio");
		Categoria p2 = new Categoria(null, "informatica");

		Produto prod1 = new Produto(null, "computador", 2000.00);
		Produto prod2 = new Produto(null, "impressora", 800.00);
		Produto prod3 = new Produto(null, "mouse", 80.00);

		produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3 )); 
		
		p1.getProdutos().addAll(Arrays.asList(prod1, prod2, prod3));
		p2.getProdutos().addAll(Arrays.asList(prod2));

		prod1.getCategorias().addAll(Arrays.asList(p1));
		prod2.getCategorias().addAll(Arrays.asList(p1, p2));
		prod3.getCategorias().addAll(Arrays.asList(p1));

		repository.saveAll(Arrays.asList(p1, p2));
		
	}

}
