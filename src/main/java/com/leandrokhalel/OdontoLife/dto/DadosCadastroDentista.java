package com.leandrokhalel.OdontoLife.dto;

import com.leandrokhalel.OdontoLife.model.Dentista;
import com.leandrokhalel.OdontoLife.model.Endereco;
import com.leandrokhalel.OdontoLife.model.Especialidade;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroDentista(

        @NotBlank
        String nome,

        @NotBlank @Email
        String email,

        @NotBlank
        String telefone,

        @NotBlank
        String cro,

        @NotNull
        Especialidade especialidade,

        @NotNull @Valid
        DadosEndereco endereco
) {
}
