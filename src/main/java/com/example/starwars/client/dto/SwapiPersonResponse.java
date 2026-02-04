package com.example.starwars.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * DTO externo (SWAPI People): solo campos necesarios.
 */
public class SwapiPersonResponse {

	@JsonProperty("name")
	private String name;

	@JsonProperty("height")
	private String height;

	@JsonProperty("mass")
	private String mass;

	@JsonProperty("hair_color")
	private String hair_color;

	@JsonProperty("skin_color")
	private String skin_color;

	@JsonProperty("eye_color")
	private String eye_color;

	@JsonProperty("birth_year")
	private String birth_year;

	@JsonProperty("gender")
	private String gender;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getMass() {
		return mass;
	}

	public void setMass(String mass) {
		this.mass = mass;
	}

	public String getHair_color() {
		return hair_color;
	}

	public void setHair_color(String hair_color) {
		this.hair_color = hair_color;
	}

	public String getSkin_color() {
		return skin_color;
	}

	public void setSkin_color(String skin_color) {
		this.skin_color = skin_color;
	}

	public String getEye_color() {
		return eye_color;
	}

	public void setEye_color(String eye_color) {
		this.eye_color = eye_color;
	}

	public String getBirth_year() {
		return birth_year;
	}

	public void setBirth_year(String birth_year) {
		this.birth_year = birth_year;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
