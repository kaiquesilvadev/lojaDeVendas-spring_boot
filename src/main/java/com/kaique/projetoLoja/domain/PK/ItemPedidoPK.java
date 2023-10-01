package com.kaique.projetoLoja.domain.PK;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kaique.projetoLoja.domain.Pedido;
import com.kaique.projetoLoja.domain.Produto;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Getter @Setter
@Embeddable
public class ItemPedidoPK implements Serializable{
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "produto_id")
	@JsonIgnoreProperties("itens")
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name = "pedido_id")
	@JsonIgnoreProperties("itens")
	private Pedido pedido;

}
