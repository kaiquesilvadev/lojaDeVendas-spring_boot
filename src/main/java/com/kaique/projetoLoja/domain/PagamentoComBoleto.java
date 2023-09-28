package com.kaique.projetoLoja.domain;

import java.util.Date;

import com.kaique.projetoLoja.enums.EstadoPagamento;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "tb_pagamentoComBoleto ")
public class PagamentoComBoleto extends Pagamento{
	private static final long serialVersionUID = 1L;
	
	private Date dataVencimento;
	private Date dataPagamento;
	
	public PagamentoComBoleto(Long id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
		super(id, estado, pedido);
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
	}
}
