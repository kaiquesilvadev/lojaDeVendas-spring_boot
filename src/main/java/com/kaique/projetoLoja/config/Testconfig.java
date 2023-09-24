package com.kaique.projetoLoja.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.kaique.projetoLoja.domain.Categoria;
import com.kaique.projetoLoja.domain.Cidade;
import com.kaique.projetoLoja.domain.Estado;
import com.kaique.projetoLoja.domain.Produto;
import com.kaique.projetoLoja.repositories.CategoriaRepository;
import com.kaique.projetoLoja.repositories.CidadeRepository;
import com.kaique.projetoLoja.repositories.EstadoRepository;
import com.kaique.projetoLoja.repositories.ProdutoRepository;

@Configuration
public class Testconfig implements CommandLineRunner {

	@Autowired
	private CategoriaRepository repository;

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;

	@Override
	public void run(String... args) throws Exception {
		Categoria p1 = new Categoria(null, "escritorio");
		Categoria p2 = new Categoria(null, "informatica");

		Produto prod1 = new Produto(null, "computador", 2000.00);
		Produto prod2 = new Produto(null, "impressora", 800.00);
		Produto prod3 = new Produto(null, "mouse", 80.00);

		
		
		p1.getProdutos().addAll(Arrays.asList(prod1, prod2, prod3));
		p2.getProdutos().addAll(Arrays.asList(prod2));

		prod1.getCategorias().addAll(Arrays.asList(p1));
		prod2.getCategorias().addAll(Arrays.asList(p1, p2));
		prod3.getCategorias().addAll(Arrays.asList(p1));
		
		produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3 )); 
		repository.saveAll(Arrays.asList(p1, p2));
		
		Estado est1 = new Estado(null , "Minas gerais");
		Estado est2 = new Estado(null , "São Paulo");
		
		Cidade c1 = new Cidade(null , "Uberlandia" , est1);
		Cidade c2 = new Cidade(null , "São Paulo" , est2);
		Cidade c3 = new Cidade(null , "Camplinas" , est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2 , c3));
		
		estadoRepository.saveAll(Arrays.asList(est1 , est2));
		cidadeRepository.saveAll(Arrays.asList(c1 , c2 , c3));
	}

}
