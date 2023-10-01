package com.kaique.projetoLoja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaique.projetoLoja.domain.ItemPedido;
import com.kaique.projetoLoja.domain.PK.ItemPedidoPK;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long>{

}
