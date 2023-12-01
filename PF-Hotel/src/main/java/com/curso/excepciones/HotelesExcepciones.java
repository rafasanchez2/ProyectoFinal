package com.curso.excepciones;

public class HotelesExcepciones extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public HotelesExcepciones(String message) {
		super(message);
	}

	public HotelesExcepciones(String message, Throwable cause) {
		super(message, cause);

	}
}
