package com.leandrokhalel.OdontoLife.service;

import com.leandrokhalel.OdontoLife.config.DentistaMapper;
import com.leandrokhalel.OdontoLife.dto.DadosAtualizacaoDentista;
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
    public DadosDetalhamentoDentista save(DadosCadastroDentista cadastro) {
        var dentista = dentistaRepository.save(DentistaMapper.fromDadosCadastroToDentista(cadastro));
        return DentistaMapper.fromDentistaToDetalhamento(dentista);
    }

    @Transactional(readOnly = true)
    public Page<DadosListagemDentista> findAllAtivos(Pageable pageable) {
        return dentistaRepository.findAllByAtivoTrue(pageable).map(DentistaMapper::fromDentistaToDadosListagem);
    }

    @Transactional(readOnly = true)
    public DadosDetalhamentoDentista getById(Long id) {
        var dentista = dentistaRepository.getReferenceById(id);
        return DentistaMapper.fromDentistaToDetalhamento(dentista);
    }

    @Transactional
    public DadosDetalhamentoDentista updateById(Long id, DadosAtualizacaoDentista request) {
        var dentista = this.dentistaRepository.getReferenceById(id);
        DentistaMapper.updateProperties(request, dentista);
        dentistaRepository.save(dentista);
        return DentistaMapper.fromDentistaToDetalhamento(dentista);
    }

    @Transactional
    public void deleteById(Long id) {
        var dentista = this.dentistaRepository.getReferenceById(id);
        dentista.setAtivo(false);
        this.dentistaRepository.save(dentista);
    }
}
