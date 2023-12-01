package com.curso.modelo;

/**
 * Clase modelo ReservaHotel, que funciona como una clase DTO de Reserva.
 */
public class ReservaHotel {

	private String nombreCliente;
	private String dni;
	private int idVuelo;

	public ReservaHotel() {
		super();
	}

	public ReservaHotel(String nombreCliente, String dni, int idVuelo) {
		super();
		this.nombreCliente = nombreCliente;
		this.dni = dni;
		this.idVuelo = idVuelo;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getIdVuelo() {
		return idVuelo;
	}

	public void setIdVuelo(int idVuelo) {
		this.idVuelo = idVuelo;
	}

}
