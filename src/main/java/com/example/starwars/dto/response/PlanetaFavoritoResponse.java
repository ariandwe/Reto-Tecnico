package com.example.starwars.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;

/**
 * DTO de salida para planetas favoritos.
 */
@Schema(name = "PlanetaFavoritoResponse")
public class PlanetaFavoritoResponse {

	@Schema(example = "1")
	private Long id;

	@Schema(example = "Tatooine")
	private String nombre;

	@Schema(example = "arido")
	private String clima;

	@Schema(example = "desierto")
	private String terreno;

	@Schema(example = "200000")
	private Long poblacion;

	@Schema(example = "2026-02-04T02:59:16")
	private LocalDateTime fechaCreacion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
}
