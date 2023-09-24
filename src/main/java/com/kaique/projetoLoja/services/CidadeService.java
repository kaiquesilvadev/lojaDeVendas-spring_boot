package com.kaique.projetoLoja.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaique.projetoLoja.domain.Cidade;
import com.kaique.projetoLoja.repositories.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repository;

	public List<Cidade> findAll() {
		return repository.findAll();
	}

	public Cidade findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public Cidade save(Cidade cidade) {
		return repository.save(cidade);
	}

	public Cidade update(Cidade cidade) {
		return repository.findById(cidade.getId()).map(x -> {
			x.setNome(cidade.getNome());
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
