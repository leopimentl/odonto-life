package com.leandrokhalel.OdontoLife.dto;

import com.leandrokhalel.OdontoLife.model.Especialidade;

public record DadosDetalhamentoDentista (
    Long id,
    String nome,
    String email,
    String telefone,
    String cro,
    Especialidade especialidade,
    DadosEndereco endereco
) {
}
