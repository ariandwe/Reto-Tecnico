package com.example.starwars.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * DTO de salida en español para personas de SWAPI.
 */
@Schema(name = "SwapiPersonaResponse")
public class SwapiPersonaResponse {

	@Schema(example = "Boba Fett")
	private String nombre;

	@Schema(example = "183")
	private String altura;

	@Schema(example = "78.2")
	private String peso;

	@Schema(example = "black")
	private String colorCabello;

	@Schema(example = "fair")
	private String colorPiel;

	@Schema(example = "brown")
	private String colorOjos;

	@Schema(example = "31.5BBY")
	private String anioNacimiento;

	@Schema(example = "male")
	private String genero;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getColorCabello() {
		return colorCabello;
	}

	public void setColorCabello(String colorCabello) {
		this.colorCabello = colorCabello;
	}

	public String getColorPiel() {
		return colorPiel;
	}

	public void setColorPiel(String colorPiel) {
		this.colorPiel = colorPiel;
	}

	public String getColorOjos() {
		return colorOjos;
	}

	public void setColorOjos(String colorOjos) {
		this.colorOjos = colorOjos;
	}

	public String getAnioNacimiento() {
		return anioNacimiento;
	}

	public void setAnioNacimiento(String anioNacimiento) {
		this.anioNacimiento = anioNacimiento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
}
