package com.realgabito.foro_hub.dto;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistrarTopico(

        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotBlank
        String autor,
        @NotBlank
        String curso
) {
}
