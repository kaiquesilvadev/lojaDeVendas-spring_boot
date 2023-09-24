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

import com.kaique.projetoLoja.domain.Produto;
import com.kaique.projetoLoja.services.ProdutoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class ProdutoResources {

	@Autowired
	private ProdutoService service;

	@GetMapping
	public ResponseEntity<List<Produto>> findAll() {
		List<Produto> listaProdutos = service.findAll();
		return listaProdutos.isEmpty() ? ResponseEntity.status(HttpStatus.NOT_FOUND).build()
				: ResponseEntity.ok().body(listaProdutos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Long id) {
		Produto categoria = service.findById(id);

		return categoria == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).build()
				: ResponseEntity.ok().body(categoria);
	}

	@PostMapping
	public ResponseEntity<Produto> sava(@Valid @RequestBody Produto produto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(produto));
	}

	@PutMapping
	public ResponseEntity<Produto> update(@Valid @RequestBody Produto produto) {
		return service.update(produto) != null ? ResponseEntity.status(HttpStatus.CREATED).body(produto)
				: ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		return service.delete(id) == true ? ResponseEntity.status(HttpStatus.NO_CONTENT).build()
				: ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
}
