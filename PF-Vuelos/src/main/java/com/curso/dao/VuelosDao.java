package com.curso.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.modelo.Vuelo;

/**
 * Interfaz que define operaciones de acceso a datos para la entidad Vuelo
 *
 * @param <Vuelo>   El tipo de entidad que representa un vuelo.
 * @param <Integer> El tipo de id de un vuelo.
 */
public interface VuelosDao extends JpaRepository<Vuelo, Integer> {
}
