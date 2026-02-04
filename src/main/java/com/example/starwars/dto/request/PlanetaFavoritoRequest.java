package com.example.starwars.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

/**
 * DTO de entrada para crear planetas favoritos.
 */
@Schema(name = "PlanetaFavoritoRequest")
public class PlanetaFavoritoRequest {

	@NotBlank
	@Schema(example = "Tatooine")
	private String nombre;

	@Schema(example = "arido")
	private String clima;

	@Schema(example = "desierto")
	private String terreno;

	@Schema(example = "200000")
	private Long poblacion;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	public String getTerreno() {
		return terreno;
	}

	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}

	public Long getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(Long poblacion) {
		this.poblacion = poblacion;
	}
}
