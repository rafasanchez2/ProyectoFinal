package com.curso.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.dao.VuelosDao;
import com.curso.excepciones.VuelosExcepciones;
import com.curso.modelo.Vuelo;

@Service
public class VuelosServiceImp implements VuelosService {
	/**
	 * Acceso a datos para la entidad Vuelo.
	 */
	@Autowired
	VuelosDao dao;

	/**
	 * Obtiene una lista de vuelos con un número igual o superior de plazas
	 * disponibles.
	 *
	 * @param plazas
	 * @return Lista de vuelos que cumplen con el numero de plazas disponibles.
	 */
	@Override
	public List<Vuelo> verPlazasDisponibles(int plazas) {
		try {
			List<Vuelo> vuelos = dao.findAll();
			List<Vuelo> resultado = new ArrayList<>();

			for (Vuelo vuelo : vuelos) {
				if (vuelo.getPlazasDisponibles() >= plazas) {
					resultado.add(vuelo);
				}
			}

			if (resultado.isEmpty()) {
				throw new VuelosExcepciones("No hay vuelos disponibles");
			}

			return resultado;
		} catch (Exception e) {
			throw new VuelosExcepciones("Error al obtener los vuelos con plazas disponibles", e);
		}
	}

	/**
	 * Reserva un número específico de plazas en un vuelo.
	 *
	 * @param id_vuelo Identificador único del vuelo.
	 * @param plazas
	 * @return {@link Vuelo} actualizado después de la reserva, o null si la reserva
	 *         no se pudo completar.
	 */
	@Override
	public Vuelo reservarPlazas(int idVuelo, int plazas) {
		try {
			List<Vuelo> vuelos = dao.findAll();

			for (Vuelo vuelo : vuelos) {
				if (vuelo.getIdVuelo() == idVuelo) {
					int plazasDisp = vuelo.getPlazasDisponibles();

					if (plazasDisp >= plazas) {
						vuelo.setPlazasDisponibles(plazasDisp - plazas);
						dao.save(vuelo);
						return vuelo;
					} else {
						throw new VuelosExcepciones(
								"No hay suficientes plazas disponibles en el vuelo con id " + idVuelo);
					}
				}
			}

			throw new VuelosExcepciones("Vuelo con id " + idVuelo + " no encontrado");
		} catch (Exception e) {
			throw new VuelosExcepciones("Error al reservar plazas en el vuelo", e);
		}
	}

	/**
	 * Añade un nuevo vuelo
	 *
	 * @param vuelo.
	 * @return Lista de vuelos después de agregar el nuevo.
	 */
	@Override
	public List<Vuelo> crearVuelo(Vuelo vuelo) {
		try {
			dao.save(vuelo);
			List<Vuelo> vuelos = dao.findAll();
			return vuelos;
		} catch (Exception e) {
			throw new VuelosExcepciones("Error al crear el vuelo", e);
		}
	}
}
