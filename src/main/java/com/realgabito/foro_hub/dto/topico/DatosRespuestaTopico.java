package com.realgabito.foro_hub.dto.topico;

public record DatosRespuestaTopico(
        Long id,
        String titulo,
        String mensaje,
        String autor,
        String curso
) {
}
