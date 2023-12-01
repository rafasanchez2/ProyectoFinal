package com.curso.service;

import java.util.List;

import com.curso.modelo.Reserva;
import com.curso.modelo.ReservaHotel;

public interface ReservasService {

	Reserva crearReserva(Reserva reserva);

	List<ReservaHotel> verReservasPorHotel(String nombreHotel);
	
	Reserva cambiarNumeroPersonas(int idReserva,int numeroPersonas);
}
