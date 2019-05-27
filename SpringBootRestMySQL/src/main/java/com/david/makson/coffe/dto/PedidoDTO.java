package com.david.makson.coffe.dto;

import java.util.List;


public class PedidoDTO {

	private Long idUsuario;
	private String nombreUsuario;
	private String dataEmissao;
	private String dataEntrega;
	private List<PlatoPedidoDTO> platoPedido;
	private String status;
	
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
	public List<PlatoPedidoDTO> getPlatoPedido() {
		return platoPedido;
	}
	public void setPlatoPedido(List<PlatoPedidoDTO> platoPedido) {
		this.platoPedido = platoPedido;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}