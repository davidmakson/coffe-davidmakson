package com.david.makson.coffe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.david.makson.coffe.model.Plato;
import com.david.makson.coffe.repository.PlatoRepository;

import io.swagger.annotations.Api;

@Api
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PlatoController {
	@Autowired
	PlatoRepository platoRepository;

	@GetMapping("/platos/{tipo}")
	public List<Plato> findByTipo(@PathVariable String tipo) {
		List<Plato> platos = new ArrayList<>();
		platos = platoRepository.findAllByTipoPlato(tipo);
		return platos;
	}
	
	@GetMapping("/platos")
	public List<Plato> findAll() {
		List<Plato> platos = new ArrayList<>();
		platos = (List<Plato>) platoRepository.findAll();
		return platos;
	}
}
