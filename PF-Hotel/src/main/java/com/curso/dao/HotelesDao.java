package com.curso.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.modelo.Hotel;

/**
 * Interfaz que define operaciones de acceso a datos para la entidad Hotel
 *
 * @param <Hotel>   El tipo de entidad que representa un hotel.
 * @param <Integer> El tipo de id de un hotel.
 */
public interface HotelesDao extends JpaRepository<Hotel, Integer> {

}
