package com.example.starwars.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

import com.example.starwars.client.SwapiPeopleClient;
import com.example.starwars.client.dto.SwapiPersonResponse;
import com.example.starwars.dto.response.SwapiPersonaResponse;
import com.example.starwars.exception.ApiException;
import com.example.starwars.mapper.SwapiPersonMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SwapiPeopleServiceImplTest {

	@Mock
	private SwapiPeopleClient swapiPeopleClient;

	@Mock
	private SwapiPersonMapper swapiPersonMapper;

	@InjectMocks
	private SwapiPeopleServiceImpl service;

	@Test
	void obtenerPersona_mapeaRespuesta() {
		SwapiPersonResponse swapiResponse = new SwapiPersonResponse();
		swapiResponse.setName("Boba Fett");

		SwapiPersonaResponse response = new SwapiPersonaResponse();
		response.setNombre("Boba Fett");

		when(swapiPeopleClient.fetchPersonById(22L)).thenReturn(swapiResponse);
		when(swapiPersonMapper.toSpanishDto(swapiResponse)).thenReturn(response);

		SwapiPersonaResponse result = service.obtenerPersona(22L);

		assertThat(result.getNombre()).isEqualTo("Boba Fett");
	}

	@Test
	void obtenerPersona_lanzaErrorSiRespuestaNula() {
		when(swapiPeopleClient.fetchPersonById(99L)).thenReturn(null);

		assertThatThrownBy(() -> service.obtenerPersona(99L))
			.isInstanceOf(ApiException.class)
			.hasMessage("SWAPI response empty");
	}
}
