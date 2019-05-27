package com.david.makson.coffe.dto;

public class PlatoPedidoDTO {

	PlatoDTO plato;
	PedidoDTO pedido;
	int quantidade;
	
	public PlatoDTO getPlato() {
		return plato;
	}
	public void setPlato(PlatoDTO plato) {
		this.plato = plato;
	}
	public PedidoDTO getPedido() {
		return pedido;
	}
	public void setPedido(PedidoDTO pedido) {
		this.pedido = pedido;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
}
