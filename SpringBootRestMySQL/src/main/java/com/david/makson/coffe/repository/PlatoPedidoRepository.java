package com.david.makson.coffe.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.david.makson.coffe.model.PlatoPedido;

@Repository
@Transactional
public interface PlatoPedidoRepository extends CrudRepository<PlatoPedido, Long> {

	@Query( "select o from PlatoPedido o where pedido.id in :pedidoId" )
	List<PlatoPedido> findAllByPedidoId(Long pedidoId);

	@Query( "select o.nome from Plato o where id in :platoId" )
	String findPlatoNameByPlatoId(Long platoId);
}
