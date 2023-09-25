package com.kaique.projetoLoja.enums;

import lombok.Getter;

@Getter 
public enum TipoCliente {

	PESSOA_FISICA(1) ,
	PESSOA_JURIDICA(2);
	
	private int cod;

	private TipoCliente(int cod) {
		this.cod = cod;
	}
	
	public static TipoCliente toRnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		for (TipoCliente x : TipoCliente.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("id inválido" + cod);
	}
}
