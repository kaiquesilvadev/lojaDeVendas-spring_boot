package com.kaique.projetoLoja.domain;

import com.kaique.projetoLoja.enums.EstadoPagamento;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "tb_pagamentoComCartao")
public class PagamentoComCartao extends Pagamento{
	private static final long serialVersionUID = 1L;
	
	private Integer numeroDeParcelas;

	public PagamentoComCartao(Long id, EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas) {
		super(id, estado, pedido);
		this.numeroDeParcelas = numeroDeParcelas;
	}
}
