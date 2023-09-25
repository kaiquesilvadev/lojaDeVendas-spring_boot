package com.kaique.projetoLoja.enums;

import lombok.Getter;

@Getter
public enum EstadoPagamento {

	PENDENTE(1),
	QUITADO(2),
	CANCELADO(3);

	private int cod;

	private EstadoPagamento(int cod) {
		this.cod = cod;
	}
	
	public static EstadoPagamento noEnum(Integer cod) {
		if(cod == null) {
			return null ;
		}
		
		for (EstadoPagamento x : EstadoPagamento.values()) {
			if(cod.equals(x.getCod())) {
				return x ;
			}
		}
		throw new IllegalArgumentException("id inválido" + cod);
	}
}
