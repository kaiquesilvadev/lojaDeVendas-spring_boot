package com.kaique.projetoLoja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaique.projetoLoja.domain.PagamentoComBoleto;
import com.kaique.projetoLoja.domain.PagamentoComCartao;

public interface PagamentoComCartaoRepository extends JpaRepository<PagamentoComCartao, Long>{

}
