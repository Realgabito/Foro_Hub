package com.realgabito.foro_hub.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.realgabito.foro_hub.dto.topico.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    Page<Topico> findByStatusTrue(Pageable paginacion);
}
