package com.david.makson.coffe.busines;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.david.makson.coffe.model.Plato;
import com.david.makson.coffe.repository.PlatoRepository;

@Component
public class OpcionesPlatos{
	
	@Autowired
	PlatoRepository repository;
	
	public List<Plato> findAllByTipoPlato(String tipoPlato){
		return repository.findAllByTipoPlato(tipoPlato);
	}
	
}
