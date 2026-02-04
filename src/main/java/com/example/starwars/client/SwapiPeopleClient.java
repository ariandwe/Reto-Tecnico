package com.example.starwars.client;

import com.example.starwars.client.dto.SwapiPersonResponse;
import com.example.starwars.exception.ApiException;
import com.example.starwars.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * Cliente HTTP para integración con SWAPI (People).
 */
@Component
public class SwapiPeopleClient {

	private static final String PEOPLE_URL = "https://swapi.py4e.com/api/people/{id}/";

	private final RestTemplate restTemplate;

	public SwapiPeopleClient(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public SwapiPersonResponse fetchPersonById(Long id) {
		try {
			ResponseEntity<SwapiPersonResponse> response =
				restTemplate.getForEntity(PEOPLE_URL, SwapiPersonResponse.class, id);
			return response.getBody();
		} catch (HttpClientErrorException.NotFound ex) {
			throw new ResourceNotFoundException("SWAPI person not found");
		} catch (HttpServerErrorException ex) {
			throw new ApiException("SWAPI unavailable");
		} catch (RestClientException ex) {
			throw new ApiException("SWAPI request failed");
		}
	}
}
