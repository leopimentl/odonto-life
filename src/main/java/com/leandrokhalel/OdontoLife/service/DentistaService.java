package com.leandrokhalel.OdontoLife.service;

import com.leandrokhalel.OdontoLife.dto.DadosCadastroDentista;
import com.leandrokhalel.OdontoLife.dto.DadosDetalhamentoDentista;
import com.leandrokhalel.OdontoLife.model.Dentista;
import com.leandrokhalel.OdontoLife.model.Endereco;
import com.leandrokhalel.OdontoLife.repository.IDentistaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DentistaService {

    final IDentistaRepository dentistaRepository;

    public DentistaService(IDentistaRepository dentistaRepository) {
        this.dentistaRepository = dentistaRepository;
    }

    @Transactional
    public DadosDetalhamentoDentista salvar(DadosCadastroDentista dto) {
        var dentista = dtoParaDentista(dto);
        dentistaRepository.save(dentista);

        return new DadosDetalhamentoDentista(dentista);
    }

    private Dentista dtoParaDentista(DadosCadastroDentista dto) {;
        return new Dentista(
                null,
                dto.nome(),
                dto.email(),
                dto.telefone(),
                dto.cro(),
                dto.especialidade(),
                new Endereco(dto.endereco())
        );
    }
}
