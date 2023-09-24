package com.kaique.projetoLoja.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaique.projetoLoja.domain.Produto;
import com.kaique.projetoLoja.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;

	public List<Produto> findAll() {
		return repository.findAll();
	}

	public Produto findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public Produto save(Produto produto) {
		return repository.save(produto);
	}

	public Produto update(Produto produto) {
		return repository.findById(produto.getId()).map(x -> {
			x.setNome(produto.getNome());
			x.setPreco(produto.getPreco());
			return repository.save(x);
		}).orElse(null);
	}

	public Boolean delete(Long id) {
		if (repository.findById(id).isPresent()) {
			repository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
}
