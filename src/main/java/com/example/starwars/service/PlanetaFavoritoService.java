package com.example.starwars.service;

import com.example.starwars.dto.request.PlanetaFavoritoRequest;
import com.example.starwars.dto.response.PlanetaFavoritoResponse;
import java.util.List;

/**
 * Service de persistencia para planetas favoritos.
 */
public interface PlanetaFavoritoService {

	PlanetaFavoritoResponse guardar(PlanetaFavoritoRequest request);

	List<PlanetaFavoritoResponse> listar();
}
