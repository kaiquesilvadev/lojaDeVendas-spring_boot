package com.kaique.projetoLoja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaique.projetoLoja.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
