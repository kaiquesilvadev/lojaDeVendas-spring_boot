package com.kaique.projetoLoja.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaique.projetoLoja.domain.Categoria;
import com.kaique.projetoLoja.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;
	
	public List<Categoria> findAll() {
		return repository.findAll();
	} 
	
	public Categoria findById(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	public Categoria save(Categoria categoria) {
	 return repository.save(categoria);
	}
}
