package com.kaique.projetoLoja.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode
@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "tb_pedido")
public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date data;
	
	@OneToOne(cascade = CascadeType.ALL ,mappedBy = "pedido")
	@JsonIgnoreProperties("pedido")
	private Pagamento pagamento;
	
	@ManyToOne
	@JsonIgnoreProperties("pedidos")
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "endereco_id")
	private Endereco enderecoDeEntrega;
	 
	
	@OneToMany(fetch = FetchType.LAZY ,  mappedBy = "id.pedido")
	@JsonIgnoreProperties("pedido")
	private List<ItemPedido> itens = new ArrayList<>();

	public Pedido(Long id, Date data,Cliente cliente, Endereco enderecoDeEntrega) {
		this.id = id;
		this.data = data;
		this.cliente = cliente;
		this.enderecoDeEntrega = enderecoDeEntrega;
	}
}
