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

import com.kaique.projetoLoja.domain.Estado;
import com.kaique.projetoLoja.services.EstadoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/estados")
public class EstadoResources {

	@Autowired
	private EstadoService service;

	@GetMapping
	public ResponseEntity<List<Estado>> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Estado> findById(@PathVariable Long id) {
		Estado estado = service.findById(id);

		return estado == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).build() : ResponseEntity.ok().body(estado);
	}

	@PostMapping
	public ResponseEntity<Estado> sava(@Valid @RequestBody Estado estado) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(estado));
	}

	@PutMapping
	public ResponseEntity<Estado> update(@Valid @RequestBody Estado estado) {
		return service.update(estado) != null ? ResponseEntity.status(HttpStatus.CREATED).body(estado)
				: ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		return service.delete(id) == true ? ResponseEntity.status(HttpStatus.NO_CONTENT).build()
				: ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
}
