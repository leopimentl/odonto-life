package com.leandrokhalel.OdontoLife.dto;

import com.leandrokhalel.OdontoLife.model.Dentista;
import com.leandrokhalel.OdontoLife.model.Especialidade;

public record DadosDetalhamentoDentista(
            Long id,

            String nome,

            String cro,

            String email,

            String telefone,

            Especialidade especialidade,

            DadosEndereco endereco
) {
    public DadosDetalhamentoDentista(Dentista dentista) {
        this(dentista.getId(),
                dentista.getNome(),
                dentista.getCro(),
                dentista.getEmail(),
                dentista.getTelefone(),
                dentista.getEspecialidade(),
                new DadosEndereco(dentista.getEndereco()));
    }
}
