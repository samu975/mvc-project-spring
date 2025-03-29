package com.rollerspeed.rollerspeed.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("RollerSpeed API")
                        .version("1.0")
                        .description("API para la gestión de instructores, estudiantes y clases de RollerSpeed."));
    }
}