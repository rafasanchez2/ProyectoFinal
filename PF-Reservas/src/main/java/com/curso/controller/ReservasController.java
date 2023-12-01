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
import com.curso.modelo.Reserva;
import com.curso.modelo.ReservaHotel;
import com.curso.service.ReservasService;

/**
 * Controlador REST para las operaciones relacionadas con reservas.
 */
@RestController
public class ReservasController {

	@Autowired
	ReservasService service;

	/**
	 * Crear una nueva reserva.
	 *
	 * @param reserva
	 */
	// localhost:9001/reservas/
	@PostMapping(value = "/reservas")
	public Reserva CrearReserva(@RequestBody Reserva reserva) {
		return service.crearReserva(reserva);
	}

	/**
	 * Obtiene la lista de reservas del hotel indicado.
	 *
	 * @param nombre_hotel
	 * @return Lista de reservas para el hotel introducido.
	 */
	// localhost:9001/reservas/{nombre_hotel}
	@GetMapping(value = "/reservas/{nombre_hotel}")
	public List<ReservaHotel> verReservasPorHotel(@PathVariable("nombre_hotel") String nombre_hotel) {
		return service.verReservasPorHotel(nombre_hotel);
	}

	/**
	 * Modifica el numero de personas para una reserva.
	 *
	 * @param id_reserva
	 * @param numero_personas
	 * @return Un objeto con la reserva modificada.
	 */
	// localhost:9001/reservas/{id_reserva}/{numero_personas}
	@PutMapping(value = "/reservas/{idReserva}/{numero_personas}")
	public Reserva cambiarNumeroPersonas(@PathVariable("idReserva") int idReserva,
			@PathVariable("numero_personas") int numero_personas) {
		return service.cambiarNumeroPersonas(idReserva, numero_personas);
	}
}
