package com.realgabito.foro_hub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.realgabito.foro_hub.dto.usuario.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


    UserDetails findByUser(String user);
    
}
