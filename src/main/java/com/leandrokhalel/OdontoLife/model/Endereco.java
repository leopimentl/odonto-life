package com.leandrokhalel.OdontoLife.model;

import com.leandrokhalel.OdontoLife.dto.EnderecoDTO;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
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

    public Endereco(EnderecoDTO dto) {
        this.uf = dto.uf();
        this.cidade = dto.cidade();
        this.logradouro = dto.logradouro();
        this.bairro = dto.bairro();
        this.numero = dto.numero();
        this.cep = dto.cep();
        this.complemento = dto.complemento();
    }
}
