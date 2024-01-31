package com.leandrokhalel.OdontoLife.controller;

import com.leandrokhalel.OdontoLife.dto.DentistaDTO;
import com.leandrokhalel.OdontoLife.service.DentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/dentistas")
public class DentistaController {

    private final DentistaService dentistaService;

    @Autowired
    public DentistaController(DentistaService dentistaService) {
        this.dentistaService = dentistaService;
    }

    @PostMapping
    public void criar(@RequestBody DentistaDTO dto, UriComponentsBuilder uriBuilder) {
        dentistaService.criar(dto);
    }
}
