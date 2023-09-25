package com.kaique.projetoLoja.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaique.projetoLoja.domain.Estado;
import com.kaique.projetoLoja.repositories.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository repository;

	public List<Estado> findAll() {
		return repository.findAll();
	}

	public Estado findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public Estado save(Estado estado) {
		return repository.save(estado);
	}

	public Estado update(Estado estado) {
		return repository.findById(estado.getId()).map(x -> {
			x.setNome(estado.getNome());
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
