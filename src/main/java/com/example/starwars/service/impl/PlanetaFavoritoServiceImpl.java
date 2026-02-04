package com.example.starwars.service.impl;

import com.example.starwars.dto.request.PlanetaFavoritoRequest;
import com.example.starwars.dto.response.PlanetaFavoritoResponse;
import com.example.starwars.entity.PlanetaFavoritoEntity;
import com.example.starwars.mapper.PlanetaFavoritoMapper;
import com.example.starwars.repository.PlanetaFavoritoRepository;
import com.example.starwars.service.PlanetaFavoritoService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 * Implementación del service de persistencia de PlanetaFavorito.
 */
@Service
public class PlanetaFavoritoServiceImpl implements PlanetaFavoritoService {

	private final PlanetaFavoritoRepository repository;
	private final PlanetaFavoritoMapper mapper;

	public PlanetaFavoritoServiceImpl(
		PlanetaFavoritoRepository repository,
		PlanetaFavoritoMapper mapper
	) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public PlanetaFavoritoResponse guardar(PlanetaFavoritoRequest request) {
		PlanetaFavoritoEntity entity = mapper.toEntity(request);
		PlanetaFavoritoEntity saved = repository.save(entity);
		return mapper.toResponse(saved);
	}

	@Override
	public List<PlanetaFavoritoResponse> listar() {
		return repository.findAll()
			.stream()
			.map(mapper::toResponse)
			.collect(Collectors.toList());
	}
}
