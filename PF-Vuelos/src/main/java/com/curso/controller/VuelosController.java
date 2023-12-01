package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.modelo.Vuelo;
import com.curso.service.VuelosService;

/**
 * Controlador REST para las operaciones relacionadas con vuelos.
 */
@RestController
public class VuelosController {

	@Autowired
	VuelosService service;

	/**
	 * Obtiene una lista de vuelos disponibles.
	 *
	 * @param plazas
	 * @return Lista de vuelos que tienen al menos el número de plazas que le
	 *         pasamos como parametro disponibles.
	 */
	@GetMapping(value = "/vuelos/{plazas}")
	public List<Vuelo> verPlazasDisponibles(@PathVariable("plazas") int plazas) {
		return service.verPlazasDisponibles(plazas);
	}

	/**
	 * Realiza una reserva de un número específico de plazas en un vuelo.
	 *
	 * @param id_vuelo
	 * @param plazas
	 * @return El vuelo especifico con sus plazas disponibles actualizadas
	 */
	@PutMapping(value = "/vuelos/{idVuelo}/{plazas}")
	public Vuelo reservarPlazas(@PathVariable("idVuelo") int idVuelo, @PathVariable("plazas") int plazas) {
		return service.reservarPlazas(idVuelo, plazas);
	}

	/**
	 * Crea un nuevo vuelo.
	 *
	 * @param vuelo
	 * @return Lista de todos los vuelos.
	 */
	@PostMapping(value = "/vuelos")
	public List<Vuelo> crearVuelo(@RequestBody Vuelo vuelo) {
		return service.crearVuelo(vuelo);
	}
}
