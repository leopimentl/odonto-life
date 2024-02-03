package com.leandrokhalel.OdontoLife.service;

import com.leandrokhalel.OdontoLife.config.DentistaMapper;
import com.leandrokhalel.OdontoLife.dto.DadosCadastroDentista;
import com.leandrokhalel.OdontoLife.dto.DadosDetalhamentoDentista;
import com.leandrokhalel.OdontoLife.dto.DadosListagemDentista;
import com.leandrokhalel.OdontoLife.repository.IDentistaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DentistaService {

    final IDentistaRepository dentistaRepository;

    public DentistaService(IDentistaRepository dentistaRepository) {
        this.dentistaRepository = dentistaRepository;
    }

    @Transactional
    public DadosListagemDentista save(DadosCadastroDentista cadastro) {
        var dentista = dentistaRepository.save(DentistaMapper.fromDadosCadastroToDentista(cadastro));

        return DentistaMapper.fromDentistaToDadosListagem(dentista);
    }

    @Transactional(readOnly = true)
    public Page<DadosListagemDentista> findAll(Pageable pageable) {

        return dentistaRepository
                .findAll(pageable)
                .map(DentistaMapper::fromDentistaToDadosListagem);
    }

    @Transactional(readOnly = true)
    public DadosDetalhamentoDentista findById(Long id) {
        var dentista = dentistaRepository.findById(id).get();

        return DentistaMapper.fromDentistaToDetalhamento(dentista);
    }
}
