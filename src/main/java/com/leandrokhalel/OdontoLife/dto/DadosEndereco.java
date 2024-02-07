package com.leandrokhalel.OdontoLife.dto;

import com.leandrokhalel.OdontoLife.model.Endereco;
import jakarta.validation.constraints.NotBlank;

public record DadosEndereco(
        @NotBlank
        String uf,
        @NotBlank
        String cidade,
        @NotBlank
        String logradouro,
        @NotBlank
        String bairro,
        @NotBlank
        String cep,
        String numero,
        String complemento
) {

    public DadosEndereco(Endereco endereco) {
        this(endereco.getUf(),
                endereco.getCidade(),
                endereco.getLogradouro(),
                endereco.getBairro(),
                endereco.getCep(),
                endereco.getNumero(),
                endereco.getComplemento());
    }
}
