package com.realgabito.foro_hub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.realgabito.foro_hub.dto.usuario.DatosAutenticacionUsuario;
import com.realgabito.foro_hub.dto.usuario.Usuario;
import com.realgabito.foro_hub.infra.security.DatosToken;
import com.realgabito.foro_hub.infra.security.TokenService;

import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AutenticacionController {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosAutenticacionUsuario datosAutenticacionUsuario) {


        Authentication authToken = new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.user(), datosAutenticacionUsuario.password());

        var usuarioAutenticado = authenticationManager.authenticate(authToken);

        var JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());

        return ResponseEntity.ok(new DatosToken(JWTtoken));
    }
}
