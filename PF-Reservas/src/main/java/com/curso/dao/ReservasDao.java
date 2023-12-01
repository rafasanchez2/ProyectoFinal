package com.curso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.curso.modelo.Reserva;

/**
 * Interfaz que define operaciones de acceso a datos para la entidad Reserva
 *
 * @param <Reserva> El tipo de entidad que representa una reserva.
 * @param <Integer> El tipo de id de una reserva.
 */
public interface ReservasDao extends JpaRepository<Reserva, Integer> {

	@Query("SELECT r FROM Reserva r WHERE r.idHotel = :idHotel")
	List<Reserva> findAllByHotelId(int idHotel);
}
