package com.leandrokhalel.OdontoLife.controller;

import com.leandrokhalel.OdontoLife.dto.DadosAtualizacaoDentista;
import com.leandrokhalel.OdontoLife.dto.DadosCadastroDentista;
import com.leandrokhalel.OdontoLife.dto.DadosDetalhamentoDentista;
import com.leandrokhalel.OdontoLife.dto.DadosListagemDentista;
import com.leandrokhalel.OdontoLife.service.DentistaService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/dentistas")
public class DentistaController {

    final DentistaService dentistaService;

    public DentistaController(DentistaService dentistaService) {
        this.dentistaService = dentistaService;
    }

    @PostMapping
    public ResponseEntity<DadosDetalhamentoDentista> save(@RequestBody @Valid DadosCadastroDentista request, UriComponentsBuilder uriBuilder) {
        var dentista = dentistaService.save(request);
        var location = uriBuilder.path("/dentistas/{id}").buildAndExpand(dentista.id()).toUri();
        return ResponseEntity.created(location).body(dentista);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemDentista>> findAllAtivos(Pageable pageable) {
        return ResponseEntity.ok(dentistaService.findAllAtivos(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoDentista> findById(@PathVariable Long id) {
        return ResponseEntity.ok(this.dentistaService.getById(id));
    }

    @PutMapping
    public ResponseEntity<DadosDetalhamentoDentista> updateById(@RequestBody DadosAtualizacaoDentista dentista) {
        return ResponseEntity.ok(dentistaService.updateById(dentista.id(), dentista));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        dentistaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
