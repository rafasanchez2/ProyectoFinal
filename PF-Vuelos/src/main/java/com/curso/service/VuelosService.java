package com.curso.service;

import java.util.List;

import com.curso.modelo.Vuelo;

public interface VuelosService {
	List<Vuelo> verPlazasDisponibles(int plazas);

	Vuelo reservarPlazas(int idVuelo, int plazas);

	List<Vuelo> crearVuelo(Vuelo vuelo);

}
