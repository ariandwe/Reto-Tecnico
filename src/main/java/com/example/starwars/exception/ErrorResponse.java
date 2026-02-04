package com.example.starwars.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Modelo de error estándar para la API.
 */
@Schema(name = "ErrorResponse")
public class ErrorResponse {

	@Schema(example = "400")
	private int status;

	@Schema(example = "Validation error")
	private String message;

	@Schema(example = "2026-02-04T08:15:00")
	private LocalDateTime timestamp;

	@Schema(example = "[\"nombre: must not be blank\"]")
	private List<String> errors;

	public ErrorResponse(int status, String message, LocalDateTime timestamp, List<String> errors) {
		this.status = status;
		this.message = message;
		this.timestamp = timestamp;
		this.errors = errors;
	}

	public int getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public List<String> getErrors() {
		return errors;
	}
}
