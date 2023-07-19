package com.hoangdp.heodat.dev.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenApiConfig {
    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI().servers(new ArrayList<Server>() {
            {
                add(new Server().url("http://localhost:8080"));
                add(new Server().url("https://wwww.hoangdp.com"));
            }
        }).info(new Info().title("Application API").description("Sample OpenAPI 3.0")
                .contact(new Contact().email("info@hoangdp.com").name("Phu").url("https://wwww.hoangdp.com"))
                .license(new License().name("Apache 2.0").url("http://www.apache.org/licenses/LICENSE-2.0.html"))
                .version("1.0.0"));
    }
}
