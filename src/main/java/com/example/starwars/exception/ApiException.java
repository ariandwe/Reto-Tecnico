package com.example.starwars.exception;

/**
 * Excepción de dominio para errores controlados del negocio.
 */
public class ApiException extends RuntimeException {

	public ApiException(String message) {
		super(message);
	}
}
