package com.example.starwars.exception;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Manejo centralizado de excepciones para la API.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	@ResponseBody
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleNotFound(ResourceNotFoundException ex) {
		return buildResponse(HttpStatus.NOT_FOUND, ex.getMessage(), null);
	}

	@ResponseBody
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException ex) {
		List<String> errors = ex.getBindingResult()
			.getFieldErrors()
			.stream()
			.map(this::formatFieldError)
			.collect(Collectors.toList());
		return buildResponse(HttpStatus.BAD_REQUEST, "Validation error", errors);
	}

	@ResponseBody
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ErrorResponse> handleBadRequest(HttpMessageNotReadableException ex) {
		return buildResponse(HttpStatus.BAD_REQUEST, "Malformed request body", null);
	}

	@ResponseBody
	@ExceptionHandler(ApiException.class)
	public ResponseEntity<ErrorResponse> handleExternal(ApiException ex) {
		return buildResponse(HttpStatus.BAD_GATEWAY, ex.getMessage(), null);
	}

	@ResponseBody
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGeneric(Exception ex) {
		return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal error", null);
	}

	private ResponseEntity<ErrorResponse> buildResponse(
		HttpStatus status,
		String message,
		List<String> errors
	) {
		ErrorResponse body = new ErrorResponse(
			status.value(),
			message,
			LocalDateTime.now(),
			errors
		);
		return ResponseEntity.status(status).body(body);
	}

	private String formatFieldError(FieldError error) {
		return error.getField() + ": " + error.getDefaultMessage();
	}
}
