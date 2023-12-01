package com.curso.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.dao.HotelesDao;
import com.curso.excepciones.HotelesExcepciones;
import com.curso.modelo.Hotel;

@Service
public class HotelesServiceImp implements HotelesService {
	/**
	 * {@link HotelesDao} se usa para acceder a la capa de acceso a datos.
	 */
	@Autowired
	HotelesDao dao;

	/**
	 * Muestra los datos de un hotel según su nombre.
	 *
	 * @param nombre
	 * @return {@link hotel} hotel buscado.
	 */
	@Override
	public Hotel verHotelesPorNombre(String nombre) {
		List<Hotel> hoteles = dao.findAll();
		Hotel hotel = null;

		for (Hotel h : hoteles) {
			if (nombre.equals(h.getNombre())) {
				hotel = h;
				break;
			}
		}
		if (hotel == null) {
			throw new HotelesExcepciones("Hotel con nombre " + nombre + " no encontrado");
		}
		return hotel;
	}

	/**
	 * Muestra la lista de hoteles disponibles
	 *
	 * @param hotel
	 * @return {@link lista} Lista con todos los hoteles.
	 */
	@Override
	public List<Hotel> verDisponibilidad() {
		List<Hotel> hoteles = dao.findAll();
		List<Hotel> resultado = new ArrayList<Hotel>();

		for (Hotel hotel : hoteles) {
			if (hotel.isDisponible()) {
				resultado.add(hotel);
			}
		}
		if (resultado.isEmpty()) {
			throw new HotelesExcepciones("No hay hoteles disponibles en este momento");
		}
		return resultado;
	}

	/**
	 * Crea un nuevo hotel.
	 *
	 * @param hotel
	 * @return {@link lista} Lista con todos los hoteles.
	 */
	@Override
	public List<Hotel> crearHotel(Hotel hotel) {
		try {
			dao.save(hotel);
			List<Hotel> hoteles = dao.findAll();
			return hoteles;
		} catch (Exception e) {
			throw new HotelesExcepciones("Error al crear el hotel", e);
		}
	}

	/**
	 * Modifica la disponibilidad de un hotel identificado por su id_hotel.
	 *
	 * @param id_hotel
	 * @return {@link Hotel} modificado con la nueva disponibilidad.
	 */
	@Override
	public Hotel cambiarDisponibilidad(int idHotel) {
		List<Hotel> hoteles = dao.findAll();
		Hotel hotel = null;

		for (Hotel h : hoteles) {
			if (h.getIdHotel() == idHotel) {
				try {
					h.setDisponible(!h.isDisponible());
					dao.save(h);
					hotel = h;
				} catch (Exception e) {
					throw new HotelesExcepciones("Error al cambiar la disponibilidad del hotel", e);
				}
			}
		}

		if (hotel == null) {
			throw new HotelesExcepciones("Hotel no encontrado");
		}

		return hotel;
	}

	/**
	 * Modifica la categoría de un hotel identificado por su id_hotel.
	 *
	 * @param id_hotel
	 * @param categoria
	 * @return {@link Hotel} modificado con la nueva categoría.
	 */
	@Override
	public Hotel cambiarCategoria(int idHotel, int categoria) {

		List<Hotel> hoteles = dao.findAll();
		Hotel hotel = null;

		for (Hotel h : hoteles) {
			if (h.getIdHotel() == idHotel) {
				try {
					h.setCategoria(categoria);
					dao.save(h);
					hotel = h;
				} catch (Exception e) {
					throw new HotelesExcepciones("Error al cambiar la categoría del hotel", e);
				}
			}
		}

		if (hotel == null) {
			throw new HotelesExcepciones("Hotel no encontrado");
		}

		return hotel;
	}
}
