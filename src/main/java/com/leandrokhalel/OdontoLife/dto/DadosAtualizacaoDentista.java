package com.leandrokhalel.OdontoLife.dto;

public record DadosAtualizacaoDentista(
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco
) {
}
