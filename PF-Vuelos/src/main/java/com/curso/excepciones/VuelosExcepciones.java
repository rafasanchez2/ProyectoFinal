package com.curso.excepciones;

public class VuelosExcepciones extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public VuelosExcepciones(String message) {
		super(message);
	}

	public VuelosExcepciones(String message, Throwable cause) {
		super(message, cause);

	}

}
