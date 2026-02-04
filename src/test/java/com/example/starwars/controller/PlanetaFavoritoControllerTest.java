package com.example.starwars.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.starwars.dto.request.PlanetaFavoritoRequest;
import com.example.starwars.dto.response.PlanetaFavoritoResponse;
import com.example.starwars.exception.GlobalExceptionHandler;
import com.example.starwars.service.PlanetaFavoritoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(PlanetaFavoritoController.class)
@Import(GlobalExceptionHandler.class)
class PlanetaFavoritoControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private PlanetaFavoritoService planetaFavoritoService;

	@Test
	void crear_planetaFavorito() throws Exception {
		PlanetaFavoritoRequest request = new PlanetaFavoritoRequest();
		request.setNombre("Tatooine");

		PlanetaFavoritoResponse response = new PlanetaFavoritoResponse();
		response.setId(1L);
		response.setNombre("Tatooine");
		response.setFechaCreacion(LocalDateTime.now());

		when(planetaFavoritoService.guardar(any(PlanetaFavoritoRequest.class))).thenReturn(response);

		mockMvc.perform(post("/api/planetas")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request)))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.id").value(1L))
			.andExpect(jsonPath("$.nombre").value("Tatooine"));
	}

	@Test
	void crear_planetaFavorito_conErrorValidacion() throws Exception {
		PlanetaFavoritoRequest request = new PlanetaFavoritoRequest();
		request.setNombre("");

		mockMvc.perform(post("/api/planetas")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request)))
			.andExpect(status().isBadRequest())
			.andExpect(jsonPath("$.status").value(400));
	}

	@Test
	void listar_planetasFavoritos() throws Exception {
		PlanetaFavoritoResponse response = new PlanetaFavoritoResponse();
		response.setId(1L);
		response.setNombre("Tatooine");

		when(planetaFavoritoService.listar()).thenReturn(List.of(response));

		mockMvc.perform(get("/api/planetas"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$[0].id").value(1L))
			.andExpect(jsonPath("$[0].nombre").value("Tatooine"));
	}
}
