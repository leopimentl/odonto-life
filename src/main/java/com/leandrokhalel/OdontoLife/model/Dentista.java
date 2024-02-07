package com.leandrokhalel.OdontoLife.model;

import com.leandrokhalel.OdontoLife.dto.DadosCadastroDentista;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "dentistas")
@Entity(name = "Dentista")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Dentista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cro;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;
}
