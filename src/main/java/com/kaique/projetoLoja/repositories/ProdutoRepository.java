package com.kaique.projetoLoja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaique.projetoLoja.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
