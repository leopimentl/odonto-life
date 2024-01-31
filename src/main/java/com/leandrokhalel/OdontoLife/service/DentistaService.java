package com.leandrokhalel.OdontoLife.service;

import com.leandrokhalel.OdontoLife.dto.DentistaDTO;
import com.leandrokhalel.OdontoLife.model.Dentista;
import com.leandrokhalel.OdontoLife.repository.IDentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DentistaService {

    private final IDentistaRepository dentistaRepository;

    @Autowired
    public DentistaService(IDentistaRepository dentistaRepository) {
        this.dentistaRepository = dentistaRepository;
    }

    @Transactional
    public void criar(DentistaDTO dto) {
        Dentista dentista = new Dentista(dto);
        dentistaRepository.save(dentista);
    }
}
