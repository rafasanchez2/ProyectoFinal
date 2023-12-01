package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.modelo.Hotel;
import com.curso.service.HotelesService;

/**
 * Controlador REST para las operaciones relacionadas con hoteles.
 */
@RestController
public class HotelesController {
	@Autowired
	HotelesService service;

	/**
	 * Devuelve una lista de hoteles por nombre.
	 *
	 * @param nombre
	 * @return Lista de hoteles que coinciden con el nombre pasado como parametro.
	 */
	// localhost:8080/hoteles/{nombre}
	@GetMapping(value = "/hoteles/{nombre}")
	public Hotel verHotelesPorNombre(@PathVariable("nombre") String nombre) {
		return service.verHotelesPorNombre(nombre);
	}

	/**
	 * 
	 *
	 * @return Lista de hoteles disponibles.
	 */
	// localhost:8080/hoteles/disponibles
	@GetMapping(value = "/hoteles/disponibles")
	public List<Hotel> verDisponibilidad() {
		return service.verDisponibilidad();
	}

	/**
	 * Crea un nuevo hotel.
	 *
	 * @param hotel
	 * @return Lista de todos los hoteles.
	 */
	// localhost:8080/hoteles
	@PostMapping(value = "/hoteles")
	public List<Hotel> crearHotel(@RequestBody Hotel hotel) {
		return service.crearHotel(hotel);
	}

	/**
	 * Actualiza la disponibilidad de un hotel.
	 *
	 * @param id_hotel
	 * @return Lista con el hotel acutalizado.
	 */
	// localhost:8080/hoteles/{id_hotel}
	@PutMapping(value = "/hoteles/{idHotel}")
	public Hotel cambiarDisponibilidad(@PathVariable("idHotel") int idHotel) {
		return service.cambiarDisponibilidad(idHotel);
	}

	/**
	 * Actualiza la categoria de un hotel.
	 *
	 * @param id_hotel
	 * @param categoria
	 * @return Lista con el hotel acutalizado.
	 */
	// localhost:8080/hoteles/categoria/{id_hotel}/{categoria}
	@PutMapping(value = "/hoteles/categoria/{idHotel}/{categoria}")
	public Hotel cambiarCategoria(@PathVariable("idHotel") int idHotel, @PathVariable("categoria") int categoria) {
		return service.cambiarCategoria(idHotel, categoria);
	}

}
