package com.kaique.projetoLoja.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaique.projetoLoja.domain.Cidade;
import com.kaique.projetoLoja.services.CidadeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cidades")
public class CidadeResources {

	@Autowired
	private CidadeService service;

	@GetMapping
	public ResponseEntity<List<Cidade>> findAll() {
		List<Cidade> listaCidades = service.findAll();
		return listaCidades.isEmpty() ? ResponseEntity.status(HttpStatus.NOT_FOUND).build()
				: ResponseEntity.ok().body(listaCidades);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cidade> findById(@PathVariable Long id) {
		Cidade cidade = service.findById(id);

		return cidade == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).build()
				: ResponseEntity.ok().body(cidade);
	}

	@PostMapping
	public ResponseEntity<Cidade> sava(@Valid @RequestBody Cidade cidade) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cidade));
	}

	@PutMapping
	public ResponseEntity<Cidade> update(@Valid @RequestBody Cidade cidade) {
		return service.update(cidade) != null ? ResponseEntity.status(HttpStatus.CREATED).body(cidade)
				: ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		return service.delete(id) == true ? ResponseEntity.status(HttpStatus.NO_CONTENT).build()
				: ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
}
