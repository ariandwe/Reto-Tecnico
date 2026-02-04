package com.example.starwars.service.impl;

import com.example.starwars.client.SwapiPeopleClient;
import com.example.starwars.client.dto.SwapiPersonResponse;
import com.example.starwars.dto.response.SwapiPersonaResponse;
import com.example.starwars.exception.ApiException;
import com.example.starwars.mapper.SwapiPersonMapper;
import com.example.starwars.service.SwapiPeopleService;
import org.springframework.stereotype.Service;

/**
 * Implementación del servicio que consume SWAPI y transforma a español.
 */
@Service
public class SwapiPeopleServiceImpl implements SwapiPeopleService {

	private final SwapiPeopleClient swapiPeopleClient;
	private final SwapiPersonMapper swapiPersonMapper;

	public SwapiPeopleServiceImpl(
		SwapiPeopleClient swapiPeopleClient,
		SwapiPersonMapper swapiPersonMapper
	) {
		this.swapiPeopleClient = swapiPeopleClient;
		this.swapiPersonMapper = swapiPersonMapper;
	}

	@Override
	public SwapiPersonaResponse obtenerPersona(Long id) {
		SwapiPersonResponse swapiResponse = swapiPeopleClient.fetchPersonById(id);
		if (swapiResponse == null) {
			throw new ApiException("SWAPI response empty");
		}
		return swapiPersonMapper.toSpanishDto(swapiResponse);
	}
}
