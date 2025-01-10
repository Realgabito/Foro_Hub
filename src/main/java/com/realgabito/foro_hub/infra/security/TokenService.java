package com.realgabito.foro_hub.infra.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.realgabito.foro_hub.dto.usuario.Usuario;


@Service
public class TokenService {
    @Value("${foro-hub.security.token.secret}")
    private String secret;
    

    public String generarToken(Usuario usuario) {

        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                     .withIssuer("foro hub")
                     .withSubject(usuario.getUsername())
                     .withClaim("id", usuario.getId())
                     
                     .sign(algorithm);
            } catch (JWTCreationException exception){
                    throw new RuntimeException();
            }
    }
    

    public String getSubject(String token) {

        if (token == null) {
            throw new RuntimeException();
        }

            DecodedJWT verifier = null;

        try {
                Algorithm algorithm = Algorithm.HMAC256(secret);
                verifier = JWT.require(algorithm)
                // specify any specific claim validations
                .withIssuer("foro hub")
                // reusable verifier instance
                .build()
                .verify(token);

                verifier.getSubject();

            } catch (JWTVerificationException exception){
                    System.out.println(exception.toString());
            }

            if (verifier.getSubject() == null ) {
                throw new RuntimeException();
            }

            return verifier.getSubject();
    }
}
