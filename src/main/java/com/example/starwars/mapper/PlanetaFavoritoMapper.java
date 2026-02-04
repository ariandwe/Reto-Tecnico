package com.example.starwars.mapper;

import com.example.starwars.dto.request.PlanetaFavoritoRequest;
import com.example.starwars.dto.response.PlanetaFavoritoResponse;
import com.example.starwars.entity.PlanetaFavoritoEntity;
import org.springframework.stereotype.Component;

/**
 * Mapper manual entre DTOs y entity de PlanetaFavorito.
 */
@Component
public class PlanetaFavoritoMapper {

	public PlanetaFavoritoEntity toEntity(PlanetaFavoritoRequest request) {
		PlanetaFavoritoEntity entity = new PlanetaFavoritoEntity();
		entity.setNombre(request.getNombre());
		entity.setClima(request.getClima());
		entity.setTerreno(request.getTerreno());
		entity.setPoblacion(request.getPoblacion());
		return entity;
	}

	public PlanetaFavoritoResponse toResponse(PlanetaFavoritoEntity entity) {
		PlanetaFavoritoResponse response = new PlanetaFavoritoResponse();
		response.setId(entity.getId());
		response.setNombre(entity.getNombre());
		response.setClima(entity.getClima());
		response.setTerreno(entity.getTerreno());
		response.setPoblacion(entity.getPoblacion());
		response.setFechaCreacion(entity.getFechaCreacion());
		return response;
	}
}
