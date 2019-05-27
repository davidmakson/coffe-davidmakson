package com.david.makson.coffe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "plato")
public class Plato {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	@Column(name = "nome")
	String nome;
	
	@Column(name = "tipoPlato")
	String tipoPlato;

	public Plato(){
	}

	public String getTipoPlato() {
		return tipoPlato;
	}

	public void setTipoPlato(String tipoPlato) {
		this.tipoPlato = tipoPlato;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
}
