package com.kaique.projetoLoja.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaique.projetoLoja.domain.Cliente;
import com.kaique.projetoLoja.repositories.ClienteRepository;


@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	public List<Cliente> findAll() {
		return repository.findAll();
	}

	public Cliente findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public Cliente save(Cliente cliente) {
		return repository.save(cliente);
	}

	public Cliente update(Cliente cliente) {
		return repository.findById(cliente.getId()).map(x -> {
			x.setNome(cliente.getNome());
			x.setEmail(cliente.getEmail());
			x.setCpfOuCnpj(cliente.getCpfOuCnpj());
			x.setTipo(cliente.getTipo());
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
