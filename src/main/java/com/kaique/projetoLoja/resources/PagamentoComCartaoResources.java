package com.kaique.projetoLoja.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaique.projetoLoja.domain.PagamentoComBoleto;
import com.kaique.projetoLoja.domain.PagamentoComCartao;
import com.kaique.projetoLoja.services.PagamentoComCartaoService;

@RestController
@RequestMapping("/comCartao")
public class PagamentoComCartaoResources {

	@Autowired
	private PagamentoComCartaoService service;

	@GetMapping
	public ResponseEntity<List<PagamentoComCartao>> findAll() {
		return service.findAll().isEmpty() ? ResponseEntity.status(HttpStatus.NOT_FOUND).build()
				: ResponseEntity.ok().body(service.findAll());
	}

	@GetMapping("{id}")
	public ResponseEntity<PagamentoComCartao> findById(@PathVariable Long id) {
		return service.findById(id) != null ? ResponseEntity.ok().body(service.findById(id))
				: ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
}
