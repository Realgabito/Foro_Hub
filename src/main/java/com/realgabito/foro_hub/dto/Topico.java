package com.realgabito.foro_hub.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity( name = "Topico")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    private LocalDateTime fechaCreacion;
    private Boolean status;
    private String autor;
    private String curso;
    


    public Topico(DatosRegistrarTopico datosRegistrarTopico) {
        this.titulo = datosRegistrarTopico.titulo();
        this.mensaje = datosRegistrarTopico.mensaje();
        fechaCreacion = LocalDateTime.now();
        this.status = true;
        this.autor = datosRegistrarTopico.autor();
        this.curso= datosRegistrarTopico.curso();
        
    }
}
