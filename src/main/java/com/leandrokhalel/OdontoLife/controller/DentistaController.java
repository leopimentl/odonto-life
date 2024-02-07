package com.leandrokhalel.OdontoLife.controller;

import com.leandrokhalel.OdontoLife.dto.DadosAtualizacaoDentista;
import com.leandrokhalel.OdontoLife.dto.DadosCadastroDentista;
import com.leandrokhalel.OdontoLife.dto.DadosDetalhamentoDentista;
import com.leandrokhalel.OdontoLife.dto.DadosListagemDentista;
import com.leandrokhalel.OdontoLife.service.DentistaService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class DentistaController {

    final DentistaService dentistaService;

    public DentistaController(DentistaService dentistaService) {
        this.dentistaService = dentistaService;
    }

    @PostMapping("/dentistas")
    public ResponseEntity<DadosDetalhamentoDentista> save(@RequestBody @Valid DadosCadastroDentista request, UriComponentsBuilder uriBuilder) {

        var dadosDentista = this.dentistaService.save(request);

        var location = uriBuilder
                .path("/dentistas/{id}")
                .buildAndExpand(dadosDentista.id())
                .toUri();

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .location(location)
                .body(dadosDentista);
    }

    @GetMapping("/dentistas")
    public ResponseEntity<Page<DadosListagemDentista>> findAllAtivos(Pageable pageable) {
        var page = this.dentistaService.findAllAtivos(pageable);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(dentistaService.findAllAtivos(pageable));
    }

    @GetMapping("/dentistas/{id}")
    public ResponseEntity<DadosDetalhamentoDentista> findById(@PathVariable Long id) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.dentistaService.getById(id));
    }

    @PutMapping("/dentistas")
    public ResponseEntity<DadosDetalhamentoDentista> updateById(@RequestBody DadosAtualizacaoDentista request) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.dentistaService.updateById(request.id(), request));
    }

    @DeleteMapping("/dentistas/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        this.dentistaService.deleteById(id);

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
