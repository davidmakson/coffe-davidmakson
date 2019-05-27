package com.david.makson.coffe.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.david.makson.coffe.model.Pedido;

@Repository
@Transactional
public interface PedidoRepository extends CrudRepository<Pedido, Long> {

	@Query( "select o from Pedido o where nombreUsuario in :usuario" )
	Pedido findByUsuario(String usuario);
	
	@Query( "select o from Pedido o where id in :id" )
	Pedido findPedidoById(Long id);
}
