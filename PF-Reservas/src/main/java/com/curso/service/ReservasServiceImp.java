package com.curso.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.dao.ReservasDao;
import com.curso.excepciones.ReservasExcepciones;
import com.curso.modelo.Hotel;
import com.curso.modelo.Reserva;
import com.curso.modelo.ReservaHotel;

@Service
public class ReservasServiceImp implements ReservasService {
	/**
	 * Acceso a datos para la entidad Reserva.
	 */
	@Autowired
	ReservasDao dao;
	/**
	 * Cliente REST utilizado para realizar llamadas a otros microservicios.
	 */
	@Autowired
	RestTemplate template;
	/**
	 * URL de los microservicios vuelos y hoteles
	 */
	String urlVuelos = "http://localhost:9000/vuelos/{id_vuelo}/{plazas}";
	String urlHoteles = "http://localhost:8080/hoteles/{nombre_hotel}";

	/**
	 * Crea una nueva reserva y actualiza las plazas en el vuelo correspondiente.
	 *
	 * @param reserva
	 * @return La reserva creada.
	 */
	@Override
	public Reserva crearReserva(Reserva reserva) {
		try {
			dao.save(reserva);
			template.put(urlVuelos, null, reserva.getIdVuelo(), reserva.getNumeroPersonas());
			return reserva;
		} catch (Exception e) {
			throw new ReservasExcepciones("Error al crear la reserva", e);
		}
	}

	/**
	 * Obtiene la lista de reservas de un hotel indicado.
	 *
	 * @param nombre_hotel
	 * @return Lista de reservas pertenecientes a ese hotel
	 */
	@Override
	public List<ReservaHotel> verReservasPorHotel(String nombreHotel) {
		try {
			Hotel hotel = template.getForObject(urlHoteles, Hotel.class, nombreHotel);

			if (hotel != null) {
				List<Reserva> reservas = dao.findAllByHotelId(hotel.getIdHotel());
				return convertirAReservaHotel(reservas);
			} else {
				return null;
			}
		} catch (Exception e) {
			throw new ReservasExcepciones("Error al obtener las reservas del hotel", e);
		}
	}

	/**
	 * Convierte una lista de reservas a formato ReservaHotel que es una clase DTO
	 * que he creado a partir de Reserva.
	 *
	 * @param reservas
	 * @return Lista de reservas convertidas a formato ReservaHotel.
	 */
	private List<ReservaHotel> convertirAReservaHotel(List<Reserva> reservas) {
		List<ReservaHotel> reservasHotel = new ArrayList<>();

		for (Reserva reserva : reservas) {
			ReservaHotel reservaHotel = new ReservaHotel();
			reservaHotel.setNombreCliente(reserva.getNombreCliente());
			reservaHotel.setDni(reserva.getDni());
			reservaHotel.setIdVuelo(reserva.getIdVuelo());
			reservasHotel.add(reservaHotel);
		}

		return reservasHotel;
	}

	/**
	 * Actualiza el número de personas en una reserva.
	 *
	 * @param id_reserva
	 * @param numero_personas
	 * @return La reserva actualizada..
	 */
	@Override
	public Reserva cambiarNumeroPersonas(int idReserva, int numeroPersonas) {
		try {
			List<Reserva> reservas = dao.findAll();
			Reserva reserva = null;

			for (Reserva r : reservas) {
				if (r.getIdReserva() == idReserva) {
					r.setNumeroPersonas(numeroPersonas);
					dao.save(r);
					reserva = r;
				}
			}

			if (reserva == null) {
				throw new ReservasExcepciones("Reserva no encontrada");
			}

			return reserva;
		} catch (Exception e) {
			throw new ReservasExcepciones("Error al cambiar el número de personas", e);
		}
	}
}