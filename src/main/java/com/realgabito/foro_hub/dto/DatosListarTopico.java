package com.realgabito.foro_hub.dto;

import java.time.LocalDateTime;

public record DatosListarTopico(
        Long id,
        String autor,
        String titulo,
        String mensaje,
        String curso,
        LocalDateTime fechaCreacion,
        Boolean status) {

    public DatosListarTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(),
                topico.getAutor(), topico.getCurso(), topico.getFechaCreacion(), topico.getStatus());
    }
}