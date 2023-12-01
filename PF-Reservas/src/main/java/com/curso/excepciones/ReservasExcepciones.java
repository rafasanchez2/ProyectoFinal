package com.curso.excepciones;

public class ReservasExcepciones extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ReservasExcepciones(String message) {
		super(message);
	}

	public ReservasExcepciones(String message, Throwable cause) {
		super(message, cause);

	}
}
