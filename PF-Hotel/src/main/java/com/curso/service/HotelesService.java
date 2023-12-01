package com.curso.service;

import java.util.List;

import com.curso.modelo.Hotel;

public interface HotelesService {
	Hotel verHotelesPorNombre(String nombre);

	List<Hotel> verDisponibilidad();

	List<Hotel> crearHotel(Hotel hotel);

	Hotel cambiarDisponibilidad(int idHotel);

	Hotel cambiarCategoria(int idHotel, int categoria);

}
