package com.kaique.projetoLoja.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaique.projetoLoja.domain.Categoria;
import com.kaique.projetoLoja.services.CategoriaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaResources {

	@Autowired
	private CategoriaService service;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> findAll() {
		List<Categoria> listaCategorias = service.findAll();
		return listaCategorias.isEmpty() ? ResponseEntity.status(HttpStatus.NOT_FOUND).build():
			ResponseEntity.ok().body(listaCategorias);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Long id) {
	 Categoria categoria = service.findById(id);
	 
	 return categoria == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).build() : 
		 ResponseEntity.ok().body(categoria);
	}
	
	@PostMapping
	public ResponseEntity<Categoria> sava(@Valid @RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(categoria));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Categoria> update(@Valid @RequestBody Categoria categoria) {
		return service.update(categoria) != null ? ResponseEntity.status(HttpStatus.CREATED).body(categoria) :
			ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
 }
 