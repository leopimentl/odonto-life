package com.leandrokhalel.OdontoLife.controller;

import com.leandrokhalel.OdontoLife.dto.DadosCadastroDentista;
import com.leandrokhalel.OdontoLife.dto.DadosDetalhamentoDentista;
import com.leandrokhalel.OdontoLife.service.DentistaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class DentistaController {

    final DentistaService dentistaService;

    public DentistaController(DentistaService dentistaService) {
        this.dentistaService = dentistaService;
    }

    @PostMapping("/dentistas")
    public ResponseEntity<DadosDetalhamentoDentista> salvarDentista(@RequestBody @Valid DadosCadastroDentista dto, UriComponentsBuilder uriBuilder) {

        var dadosDentista = dentistaService.salvar(dto);

        var location = uriBuilder
                .path("/dentistas/{id}")
                .buildAndExpand(dadosDentista.id())
                .toUri();

        return ResponseEntity.status(HttpStatus.CREATED).location(location).body(dadosDentista);
    }
}
