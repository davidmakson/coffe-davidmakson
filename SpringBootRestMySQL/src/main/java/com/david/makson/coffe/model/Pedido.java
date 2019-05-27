package com.david.makson.coffe.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "idUsuario")
	private Long idUsuario;
	
	@Column(name = "nombreUsuario")
	private String nombreUsuario;

	@Column(name = "dataEmissao")
	private String dataEmissao;
	
	@Column(name = "dataEntrega")
	private String dataEntrega;
	
	@OneToMany(mappedBy="pedido")
	private Collection<PlatoPedido> platoPedido;

	@Column(name = "status")
	String status;
	
	public Pedido() {
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Collection<PlatoPedido> getPlatoPedido() {
		return platoPedido;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(String dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public String getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(String dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public void setPlatoPedido(List<PlatoPedido> platoPedido) {
		this.platoPedido = platoPedido;
	}

	public boolean isPresent() {
		if(this.id != null) {
			return true;
		}
		return false;
	}
}