package com.david.makson.coffe.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.david.makson.coffe.model.Plato;

@Repository
@Transactional
public interface PlatoRepository extends CrudRepository<Plato, Long> {

	@Query( "select o from Plato o where tipoPlato in :tipoPlato" )
	List<Plato> findAllByTipoPlato(String tipoPlato);
	@Query( "select o from Plato o where id in :id" )
	Plato findByIdentificador(Long id);
}
