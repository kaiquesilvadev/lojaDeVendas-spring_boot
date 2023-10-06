package com.kaique.projetoLoja.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaique.projetoLoja.domain.PagamentoComCartao;
import com.kaique.projetoLoja.repositories.PagamentoComCartaoRepository;

@Service
public class PagamentoComCartaoService {

		@Autowired
		private PagamentoComCartaoRepository repository;
		
		public List<PagamentoComCartao> findAll(){
			return repository.findAll();
		}

		public PagamentoComCartao findById(Long id) {
			return repository.findById(id).orElse(null);
		}
		
		public Boolean delete(Long id) {
			if(repository.findById(id).isPresent()) {
				 repository.deleteById(id);
			 return true ;
			}else {
				return false;
			}
		}
	}
