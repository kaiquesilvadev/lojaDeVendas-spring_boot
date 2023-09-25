package com.kaique.projetoLoja.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaique.projetoLoja.domain.Endereco;
import com.kaique.projetoLoja.repositories.EnderecoRepository;


@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repository;

	public List<Endereco> findAll() {
		return repository.findAll();
	}

	public Endereco findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public Endereco save(Endereco endereco) {
		return repository.save(endereco);
	}

	public Endereco update(Endereco endereco) {
		return repository.findById(endereco.getId()).map(x -> {
			x.setLogradouro(endereco.getLogradouro());
			x.setNumero(endereco.getNumero());
			x.setComplemento(endereco.getComplemento());
			x.setBairro(endereco.getBairro());
			x.setCep(endereco.getCep());
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
