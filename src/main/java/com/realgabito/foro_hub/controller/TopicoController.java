package com.realgabito.foro_hub.controller;

import com.realgabito.foro_hub.dto.DatosListarTopico;
import com.realgabito.foro_hub.dto.DatosRegistrarTopico;
import com.realgabito.foro_hub.dto.DatosRespuestaTopico;
import com.realgabito.foro_hub.dto.Topico;
import com.realgabito.foro_hub.repository.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;


    @PostMapping
    public ResponseEntity <DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosRegistrarTopico datosRegistrarTopico, UriComponentsBuilder uriComponentsBuilder) {

        //Save new topic | Guardar nuevo topico
        Topico topico = topicoRepository.save(new Topico(datosRegistrarTopico));


        var datosRespuestaTopico = new DatosRespuestaTopico(topico.getId(), topico.getAutor(), topico.getTitulo(), topico.getMensaje(), topico.getCurso());

        //Build the response DTO
        URI uri = uriComponentsBuilder.path("/topicos/{id}")
                .buildAndExpand(topico.getId())
                .toUri();

        return ResponseEntity.created(uri).body(datosRespuestaTopico);
    }

    @GetMapping
    public  ResponseEntity<Page<DatosListarTopico>> listarTopico(@PageableDefault(size = 10)Pageable paginacion) {
        return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(DatosListarTopico::new));
    }
}
