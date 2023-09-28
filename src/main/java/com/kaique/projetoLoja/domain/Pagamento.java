package com.kaique.projetoLoja.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kaique.projetoLoja.enums.EstadoPagamento;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "tb_pagamento")
@Inheritance(strategy = InheritanceType.JOINED)
public class Pagamento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	private EstadoPagamento estado;
	
	@OneToOne
	@JoinColumn(name = "pedigo_id")
	@MapsId
	@JsonIgnoreProperties("pagamento")
	private Pedido pedido;
}
