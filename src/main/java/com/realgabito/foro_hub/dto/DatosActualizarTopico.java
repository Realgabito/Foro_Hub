package com.realgabito.foro_hub.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(

    
    @NotNull
    Long id,
 
    String autor,

    String titulo,

    String mensaje,

    String curso
) {

}
