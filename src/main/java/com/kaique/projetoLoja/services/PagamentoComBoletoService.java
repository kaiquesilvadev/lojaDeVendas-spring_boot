package com.kaique.projetoLoja.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaique.projetoLoja.domain.PagamentoComBoleto;
import com.kaique.projetoLoja.repositories.PagamentoComBoletoRepository;

@Service
public class PagamentoComBoletoService {

		@Autowired
		private PagamentoComBoletoRepository repository;
		
		public List<PagamentoComBoleto> findAll(){
			return repository.findAll();
		}

		public PagamentoComBoleto findById(Long id) {
			return repository.findById(id).orElse(null);
		}
	}
