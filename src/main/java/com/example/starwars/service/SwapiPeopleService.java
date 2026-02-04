package com.example.starwars.service;

import com.example.starwars.dto.response.SwapiPersonaResponse;

/**
 * Service layer: orquesta cliente SWAPI y mapeo a DTO en español.
 */
public interface SwapiPeopleService {

	SwapiPersonaResponse obtenerPersona(Long id);
}
