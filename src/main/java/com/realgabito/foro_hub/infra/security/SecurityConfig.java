package com.realgabito.foro_hub.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // return http.csrf(csrf -> csrf.disable()) // Deshabilita CSRF (útil para APIs REST)
        //         .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Sin estado
        //         .authorizeHttpRequests(req -> req

        //             .requestMatchers(HttpMethod.POST, "/login").permitAll()
        //             // Permitir acceso público a todos los endpoints POST
                    
        //             // Permitir acceso público a Swagger y documentación
        //             .requestMatchers("/v3/api-docs/**", "/swagger-ui.html", "/swagger-ui/**").permitAll()
        //             // Permitir acceso público a GET en /topicos
        //             .requestMatchers(HttpMethod.GET, "/topicos/**").permitAll()
        //             //Permitir accesso publico a PUT en todos los Endpoints
        //             .requestMatchers(HttpMethod.PUT, "/topicos/**").permitAll()
        //             //Permitir accesso publico a los endpoints DELETE
        //             .requestMatchers(HttpMethod.DELETE, "/topicos/**").permitAll()
        //             // Cualquier otra solicitud requiere autenticación
        //             .anyRequest().authenticated()
        //         )
        return http.csrf(csrf -> csrf.disable())
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(req -> {
                    req.requestMatchers(HttpMethod.POST, "/login").permitAll()
                    .requestMatchers("/v3/api-docs/**", "/swagger-ui.html", "/swagger-ui/**").permitAll()
                    .anyRequest().authenticated();
                })
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    }
