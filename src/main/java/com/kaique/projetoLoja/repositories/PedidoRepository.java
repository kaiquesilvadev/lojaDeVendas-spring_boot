package com.kaique.projetoLoja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaique.projetoLoja.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
}
