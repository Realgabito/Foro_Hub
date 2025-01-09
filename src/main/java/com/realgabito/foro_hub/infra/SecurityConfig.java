package com.realgabito.foro_hub.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(csrf -> csrf.disable()) // Deshabilita CSRF (útil para APIs REST)
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Sin estado
                .authorizeHttpRequests(req -> req
                    // Permitir acceso público a todos los endpoints POST
                    .requestMatchers(HttpMethod.POST, "/**").permitAll()
                    // Permitir acceso público a Swagger y documentación
                    .requestMatchers("/v3/api-docs/**", "/swagger-ui.html", "/swagger-ui/**").permitAll()
                    // Permitir acceso público a GET en /topicos
                    .requestMatchers(HttpMethod.GET, "/topicos/**").permitAll()
                    // Cualquier otra solicitud requiere autenticación
                    .anyRequest().authenticated()
                )
                
                .build();
    }
    }
