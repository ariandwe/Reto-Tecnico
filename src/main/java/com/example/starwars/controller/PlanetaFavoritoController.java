package com.example.starwars.controller;

import com.example.starwars.dto.request.PlanetaFavoritoRequest;
import com.example.starwars.dto.response.PlanetaFavoritoResponse;
import com.example.starwars.service.PlanetaFavoritoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller para planetas favoritos (MySQL).
 */
@RestController
@RequestMapping("/api")
public class PlanetaFavoritoController {

	private final PlanetaFavoritoService planetaFavoritoService;

	public PlanetaFavoritoController(PlanetaFavoritoService planetaFavoritoService) {
		this.planetaFavoritoService = planetaFavoritoService;
	}

	@PostMapping("/planetas")
	@Operation(
		summary = "Crear planeta favorito",
		description = "Guarda un planeta favorito en la base de datos."
	)
	@ApiResponses({
		@ApiResponse(
			responseCode = "200",
			description = "Planeta creado",
			content = @Content(schema = @Schema(implementation = PlanetaFavoritoResponse.class))
		),
		@ApiResponse(responseCode = "400", description = "Datos inválidos"),
		@ApiResponse(responseCode = "500", description = "Error interno")
	})
	public ResponseEntity<PlanetaFavoritoResponse> crear(@Valid @RequestBody PlanetaFavoritoRequest request) {
		return ResponseEntity.ok(planetaFavoritoService.guardar(request));
	}

	@GetMapping("/planetas")
	@Operation(
		summary = "Listar planetas favoritos",
		description = "Obtiene todos los planetas favoritos almacenados."
	)
	@ApiResponses({
		@ApiResponse(
			responseCode = "200",
			description = "Listado de planetas",
			content = @Content(
				array = @ArraySchema(schema = @Schema(implementation = PlanetaFavoritoResponse.class))
			)
		),
		@ApiResponse(responseCode = "500", description = "Error interno")
	})
	public ResponseEntity<List<PlanetaFavoritoResponse>> listar() {
		return ResponseEntity.ok(planetaFavoritoService.listar());
	}
}
