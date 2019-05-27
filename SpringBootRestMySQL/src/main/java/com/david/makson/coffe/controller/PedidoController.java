package com.david.makson.coffe.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.david.makson.coffe.busines.PedidoCliente;
import com.david.makson.coffe.dto.PedidoDTO;
import com.david.makson.coffe.model.Pedido;
import com.david.makson.coffe.repository.PedidoRepository;
import com.david.makson.coffe.repository.PlatoPedidoRepository;
import com.david.makson.coffe.repository.PlatoRepository;

import io.swagger.annotations.Api;

@Api
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PedidoController {
	@Autowired
	PlatoRepository platoRepository;
	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	PlatoPedidoRepository platoPedidoRepository;
	@Autowired
	PedidoCliente pedidoCliente;
	
	@PostMapping("/pedido/add")
	public PedidoDTO postPedido(@RequestBody PedidoDTO dto) {
		pedidoCliente.crearPedido(dto);
		return dto;
	}

	@GetMapping("/pedido")
	public PedidoDTO findByUsuario(@PathVariable("usuario") String usuario) {
		Pedido pedido = pedidoCliente.buscarPedido(usuario);
		PedidoDTO pedidoRetornado = new PedidoDTO();
		pedidoRetornado.setDataEmissao(pedido.getDataEmissao());
		pedidoRetornado.setStatus(pedido.getStatus());
		pedidoRetornado.setNombreUsuario(pedido.getNombreUsuario());
		return pedidoRetornado;
	}
	@PutMapping("/pedido/{status}")
	public ResponseEntity<Pedido> updateCustomer(@PathVariable("status") String status, @RequestBody PedidoDTO dto) {
		Pedido pedidoData = pedidoCliente.buscarPedido(dto.getNombreUsuario());
		if (pedidoData.isPresent()) {
			pedidoData.setStatus(status);
			return new ResponseEntity<>(pedidoRepository.save(pedidoData), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
