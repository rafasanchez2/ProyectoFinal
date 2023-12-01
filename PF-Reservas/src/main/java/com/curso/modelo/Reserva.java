package com.curso.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * {@link Entity} indica que esta clase es una entidad JPA, así que se
 * almacenará en nuestra BBDD. 
 * {@link Table} especifica el nombre de la tabla en la BBDD.
 */
@Entity
@Table(name = "reservas")
public class Reserva {
	/**
	 * Identificador único de la clase.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_reserva")
	private int idReserva;
	@Column(name = "nombre_cliente")
	private String nombreCliente;
	private String dni;
	@Column(name = "id_hotel")
	private int idHotel;
	@Column(name = "id_vuelo")
	private int idVuelo;
	@Column(name = "numero_personas")
	private int numeroPersonas;

	public Reserva() {
		super();
	}

	public Reserva(int idReserva, String nombreCliente, String dni, int idHotel, int idVuelo, int numeroPersonas) {
		super();
		this.idReserva = idReserva;
		this.nombreCliente = nombreCliente;
		this.dni = dni;
		this.idHotel = idHotel;
		this.idVuelo = idVuelo;
		this.numeroPersonas = numeroPersonas;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public int getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
	}

	public int getIdVuelo() {
		return idVuelo;
	}

	public void setIdVuelo(int idVuelo) {
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

	public int getNumeroPersonas() {
		return numeroPersonas;
	}

	public void setNumeroPersonas(int numeroPersonas) {
		this.numeroPersonas = numeroPersonas;
	}

}
