package com.leandrokhalel.OdontoLife.dto;

import com.leandrokhalel.OdontoLife.model.Especialidade;

public record DadosListagemDentista(
            Long id,
            String nome,
            String cro,
            String email,
            Especialidade especialidade
) {
}
