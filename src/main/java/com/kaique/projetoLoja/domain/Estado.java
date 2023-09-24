package com.kaique.projetoLoja.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@EqualsAndHashCode
@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "tb_estado")
public class Estado implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nome;

	@OneToMany(mappedBy = "estado")
	@JsonIgnoreProperties("estado")
	private List<Cidade> cidades = new ArrayList<>();
	
	public Estado(Long id, @NotBlank String nome) {
		this.id = id;
		this.nome = nome;
	}
}
