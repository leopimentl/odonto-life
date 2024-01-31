package com.leandrokhalel.OdontoLife.model;

import com.leandrokhalel.OdontoLife.dto.DentistaDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "dentistas")
@Entity(name = "Dentista")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Dentista {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String cro;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    public Dentista(DentistaDTO dto) {
        this.nome = dto.nome();
        this.email = dto.email();
        this.cro = dto.cro();
        this.especialidade = dto.especialidade();
        this.endereco = new Endereco(dto.endereco());
    }
}
