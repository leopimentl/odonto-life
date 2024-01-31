package com.leandrokhalel.OdontoLife.dto;

import jakarta.validation.constraints.NotBlank;

public record EnderecoDTO(

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
}
