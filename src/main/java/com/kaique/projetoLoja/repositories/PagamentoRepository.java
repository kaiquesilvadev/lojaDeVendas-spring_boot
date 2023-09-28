package com.kaique.projetoLoja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaique.projetoLoja.domain.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long>{

}
