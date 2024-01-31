package com.leandrokhalel.OdontoLife.dto;

import com.leandrokhalel.OdontoLife.model.Especialidade;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DentistaDTO(

        @NotBlank
        String nome,

        @NotBlank @Email
        String email,

        @NotBlank @Pattern(regexp = "\\d{11}")
        String cro,

        @NotNull
        Especialidade especialidade,

        @NotNull @Valid
        EnderecoDTO endereco
) {
}
