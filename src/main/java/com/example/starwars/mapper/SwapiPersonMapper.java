package com.example.starwars.mapper;

import com.example.starwars.client.dto.SwapiPersonResponse;
import com.example.starwars.dto.response.SwapiPersonaResponse;
import org.springframework.stereotype.Component;

/**
 * Mapper manual: transforma respuesta SWAPI a DTO en español.
 */
@Component
public class SwapiPersonMapper {

	public SwapiPersonaResponse toSpanishDto(SwapiPersonResponse swapiResponse) {
		SwapiPersonaResponse response = new SwapiPersonaResponse();
		response.setNombre(swapiResponse.getName());
		response.setAltura(swapiResponse.getHeight());
		response.setPeso(swapiResponse.getMass());
		response.setColorCabello(swapiResponse.getHair_color());
		response.setColorPiel(swapiResponse.getSkin_color());
		response.setColorOjos(swapiResponse.getEye_color());
		response.setAnioNacimiento(swapiResponse.getBirth_year());
		response.setGenero(swapiResponse.getGender());
		return response;
	}
}
