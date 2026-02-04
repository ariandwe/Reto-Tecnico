package com.example.starwars.controller;

import com.example.starwars.dto.response.SwapiPersonaResponse;
import com.example.starwars.service.SwapiPeopleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller para personajes (SWAPI).
 */
@RestController
@RequestMapping("/api")
public class SwapiPeopleController {

	private final SwapiPeopleService swapiPeopleService;

	public SwapiPeopleController(SwapiPeopleService swapiPeopleService) {
		this.swapiPeopleService = swapiPeopleService;
	}

	@GetMapping("/personajes/{id}")
	@Operation(
		summary = "Obtener personaje por ID",
		description = "Consulta un personaje en SWAPI y devuelve el DTO en español."
	)
	@ApiResponses({
		@ApiResponse(
			responseCode = "200",
			description = "Personaje encontrado",
			content = @Content(schema = @Schema(implementation = SwapiPersonaResponse.class))
		),
		@ApiResponse(responseCode = "404", description = "Personaje no encontrado"),
		@ApiResponse(responseCode = "502", description = "Error de integración con SWAPI"),
		@ApiResponse(responseCode = "500", description = "Error interno")
	})
	public ResponseEntity<SwapiPersonaResponse> obtenerPersonaje(@PathVariable Long id) {
		return ResponseEntity.ok(swapiPeopleService.obtenerPersona(id));
	}
}
