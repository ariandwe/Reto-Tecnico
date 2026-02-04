package com.example.starwars.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuración de Swagger/OpenAPI.
 */
@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI customOpenApi() {
		return new OpenAPI()
			.info(new Info()
				.title("Star Wars API")
				.description("API local para integrar SWAPI y persistir planetas favoritos")
				.version("1.0.0"));
	}
}
