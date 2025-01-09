package com.realgabito.foro_hub.controller;

import com.realgabito.foro_hub.dto.DatosActualizarTopico;
import com.realgabito.foro_hub.dto.DatosListarTopico;
import com.realgabito.foro_hub.dto.DatosRegistrarTopico;
import com.realgabito.foro_hub.dto.DatosRespuestaTopico;
import com.realgabito.foro_hub.dto.Topico;
import com.realgabito.foro_hub.repository.TopicoRepository;

import jakarta.transaction.Transactional;
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

    // @GetMapping
    // public  ResponseEntity<Page<DatosListarTopico>> listarTopico(@PageableDefault(size = 10)Pageable paginacion) {
    //     return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(DatosListarTopico::new));
    // }

    @GetMapping
    public ResponseEntity<Page<Object>> listarTopicosActivos(@PageableDefault(size = 10) Pageable paginacion) {
        return ResponseEntity.ok(topicoRepository.findByStatusTrue(paginacion).map(DatosListarTopico::new));
    }


    @GetMapping("/{id}")
    public ResponseEntity <DatosRespuestaTopico> buscarTopicoById(@PathVariable Long id) {
        
        //Search in Db a matching result and thorw a message in case there is not a match
        Topico topico = topicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Topico no encontrado"));

        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getAutor(), topico.getCurso());

        return ResponseEntity.ok(datosRespuestaTopico);
    }


    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizarTopico DatosActualizarTopico) {

        Topico topico = topicoRepository.getReferenceById(DatosActualizarTopico.id());

        topico.actualizarTopico(DatosActualizarTopico);

        return ResponseEntity.ok(new DatosRespuestaTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getAutor(), topico.getCurso()));
    }
    
    
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);

        topico.eliminarTopico();

        return ResponseEntity.noContent().build();
    }
}
