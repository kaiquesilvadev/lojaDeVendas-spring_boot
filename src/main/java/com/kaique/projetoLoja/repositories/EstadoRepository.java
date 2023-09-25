package com.kaique.projetoLoja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaique.projetoLoja.domain.Endereco;

public interface EstadoRepository extends JpaRepository<Endereco, Long>{

}
