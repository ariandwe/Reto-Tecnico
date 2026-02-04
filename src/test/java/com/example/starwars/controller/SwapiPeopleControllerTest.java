package com.example.starwars.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.starwars.dto.response.SwapiPersonaResponse;
import com.example.starwars.exception.GlobalExceptionHandler;
import com.example.starwars.exception.ResourceNotFoundException;
import com.example.starwars.service.SwapiPeopleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(SwapiPeopleController.class)
@Import(GlobalExceptionHandler.class)
class SwapiPeopleControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private SwapiPeopleService swapiPeopleService;

	@Test
	void obtenerPersonaje_ok() throws Exception {
		SwapiPersonaResponse response = new SwapiPersonaResponse();
		response.setNombre("Boba Fett");
		response.setAltura("183");

		when(swapiPeopleService.obtenerPersona(22L)).thenReturn(response);

		mockMvc.perform(get("/api/personajes/22"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.nombre").value("Boba Fett"))
			.andExpect(jsonPath("$.altura").value("183"));
	}

	@Test
	void obtenerPersonaje_noEncontrado() throws Exception {
		when(swapiPeopleService.obtenerPersona(999L))
			.thenThrow(new ResourceNotFoundException("SWAPI person not found"));

		mockMvc.perform(get("/api/personajes/999"))
			.andExpect(status().isNotFound())
			.andExpect(jsonPath("$.status").value(404));
	}
}
