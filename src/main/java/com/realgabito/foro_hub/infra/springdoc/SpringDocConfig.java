package com.realgabito.foro_hub.infra.springdoc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .components(new Components()
            .addSecuritySchemes("bearer-key",
            new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")))
            
            
            .info(new Info()
                        .title("Foro Hub Api")
                        .description("La API Foro Hub es un servicio RESTful diseñado para gestionar foros de discusión en línea. Permite a los usuarios crear, actualizar y eliminar temas, así como autenticar y gestionar el acceso de usuarios mediante seguridad basada en JWT.")
                        .contact(new Contact()
                                        .name("Victor Perdomo")
                                        .email("victorgabperdomo@gmail.com")
                                        .url("https://github.com/Realgabito"))
                        .license(new License()
                                        .name("Apache 2.0")
                                        ));
}
}
