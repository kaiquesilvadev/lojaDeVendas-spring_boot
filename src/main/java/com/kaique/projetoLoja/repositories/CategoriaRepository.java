package com.kaique.projetoLoja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaique.projetoLoja.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
