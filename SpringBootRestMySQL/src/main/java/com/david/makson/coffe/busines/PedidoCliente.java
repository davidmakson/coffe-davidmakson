package com.david.makson.coffe.busines;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.david.makson.coffe.dto.PedidoDTO;
import com.david.makson.coffe.dto.PlatoPedidoDTO;
import com.david.makson.coffe.enums.PedidoStatus;
import com.david.makson.coffe.model.Pedido;
import com.david.makson.coffe.model.Plato;
import com.david.makson.coffe.model.PlatoPedido;
import com.david.makson.coffe.repository.PedidoRepository;
import com.david.makson.coffe.repository.PlatoPedidoRepository;
import com.david.makson.coffe.repository.PlatoRepository;

@Component
public class PedidoCliente{
	
	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	PlatoPedidoRepository platoPedidoRepository;
	@Autowired
	PlatoRepository platoRepository;
	
	public Pedido crearPedido(PedidoDTO dto) {
		dto.setStatus(PedidoStatus.EMITIDO.name());
		
		Pedido pedido = new Pedido();
		pedido.setNombreUsuario(dto.getNombreUsuario());
		pedido.setIdUsuario(dto.getIdUsuario());
		pedido.setDataEmissao(dto.getDataEmissao());
		pedido.setStatus(dto.getStatus());
		Pedido pedidoSalvo = pedidoRepository.save(pedido);
		
		List<PlatoPedido> platosPedidos = new ArrayList<>();
		for(PlatoPedidoDTO plato : dto.getPlatoPedido()) {
			PlatoPedido platoPedido = new PlatoPedido();
			Pedido novoPedido = new Pedido();
			Plato novoPlato = platoRepository.findByIdentificador(plato.getPlato().getId());
			platoPedido.setPlato(novoPlato);
			platoPedido.getPlato().setNome(plato.getPlato().getNome());
			platoPedido.getPlato().setTipoPlato(plato.getPlato().getTipoPlato());
			platoPedido.setQuantidade(plato.getQuantidade());
			platoPedido.setPedido(novoPedido);
			platoPedido.getPedido().setId(pedidoSalvo.getId());
			platosPedidos.add(platoPedido);
			platoPedidoRepository.save(platoPedido);
		}
		
		pedidoSalvo.setPlatoPedido(platosPedidos);
		return pedidoRepository.save(pedidoSalvo);
	}

	public void cancelarPedido(Pedido pedido) {
		Pedido pedidoAtualizado = pedido;
		pedidoAtualizado.setStatus(PedidoStatus.CANCELADO.name());
		pedidoRepository.save(pedidoAtualizado);
	}

	public void pagarPedido(Pedido pedido) {
		Pedido pedidoAtualizado = pedido;
		pedidoAtualizado.setStatus(PedidoStatus.PAGADO.name());
		pedidoRepository.save(pedidoAtualizado);
	}

	public Pedido buscarPedido(String usuario) {
		Pedido pedido = new Pedido();
		pedido = pedidoRepository.findByUsuario(usuario);
		return pedido;
	}
}