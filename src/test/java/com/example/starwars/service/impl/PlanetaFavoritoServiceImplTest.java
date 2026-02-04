package com.example.starwars.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.starwars.dto.request.PlanetaFavoritoRequest;
import com.example.starwars.dto.response.PlanetaFavoritoResponse;
import com.example.starwars.entity.PlanetaFavoritoEntity;
import com.example.starwars.mapper.PlanetaFavoritoMapper;
import com.example.starwars.repository.PlanetaFavoritoRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PlanetaFavoritoServiceImplTest {

	@Mock
	private PlanetaFavoritoRepository repository;

	@Mock
	private PlanetaFavoritoMapper mapper;

	@InjectMocks
	private PlanetaFavoritoServiceImpl service;

	@Test
	void guardar_creaPlanetaFavorito() {
		PlanetaFavoritoRequest request = new PlanetaFavoritoRequest();
		request.setNombre("Tatooine");

		PlanetaFavoritoEntity entity = new PlanetaFavoritoEntity();
		entity.setNombre("Tatooine");

		PlanetaFavoritoEntity saved = new PlanetaFavoritoEntity();
		saved.setNombre("Tatooine");

		PlanetaFavoritoResponse response = new PlanetaFavoritoResponse();
		response.setId(1L);
		response.setNombre("Tatooine");
		response.setFechaCreacion(LocalDateTime.now());

		when(mapper.toEntity(request)).thenReturn(entity);
		when(repository.save(entity)).thenReturn(saved);
		when(mapper.toResponse(saved)).thenReturn(response);

		PlanetaFavoritoResponse result = service.guardar(request);

		assertThat(result.getId()).isEqualTo(1L);
		assertThat(result.getNombre()).isEqualTo("Tatooine");
		verify(repository).save(entity);
	}

	@Test
	void listar_retornaPlanetas() {
		PlanetaFavoritoEntity entity = new PlanetaFavoritoEntity();
		entity.setNombre("Hoth");

		PlanetaFavoritoResponse response = new PlanetaFavoritoResponse();
		response.setId(2L);
		response.setNombre("Hoth");

		when(repository.findAll()).thenReturn(List.of(entity));
		when(mapper.toResponse(entity)).thenReturn(response);

		List<PlanetaFavoritoResponse> result = service.listar();

		assertThat(result).hasSize(1);
		assertThat(result.get(0).getNombre()).isEqualTo("Hoth");
	}
}
