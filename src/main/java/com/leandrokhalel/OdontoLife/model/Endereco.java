package com.leandrokhalel.OdontoLife.model;

import com.leandrokhalel.OdontoLife.dto.DadosEndereco;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String uf;
    private String cidade;
    private String logradouro;
    private String bairro;
    private String numero;
    private String cep;
    private String complemento;

    public Endereco(DadosEndereco endereco) {
        this(endereco.uf(),
                endereco.cidade(),
                endereco.logradouro(),
                endereco.bairro(),
                endereco.cep(),
                endereco.numero(),
                endereco.complemento());
    }
}
