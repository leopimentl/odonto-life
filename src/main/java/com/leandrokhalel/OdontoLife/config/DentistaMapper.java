package com.leandrokhalel.OdontoLife.config;

import com.leandrokhalel.OdontoLife.dto.DadosCadastroDentista;
import com.leandrokhalel.OdontoLife.dto.DadosDetalhamentoDentista;
import com.leandrokhalel.OdontoLife.dto.DadosEndereco;
import com.leandrokhalel.OdontoLife.dto.DadosListagemDentista;
import com.leandrokhalel.OdontoLife.model.Dentista;
import com.leandrokhalel.OdontoLife.model.Endereco;

public class DentistaMapper {

    public static Dentista fromDadosCadastroToDentista(DadosCadastroDentista cadastro) {
        return new Dentista(
                null,
                cadastro.nome(),
                cadastro.email(),
                cadastro.telefone(),
                cadastro.cro(),
                cadastro.especialidade(),
                new Endereco(cadastro.endereco())
        );
    }

    public static DadosListagemDentista fromDentistaToDadosListagem(Dentista dentista) {
        return new DadosListagemDentista(
                dentista.getId(),
                dentista.getNome(),
                dentista.getCro(),
                dentista.getEmail(),
                dentista.getEspecialidade()
        );
    }

    public static DadosDetalhamentoDentista fromDentistaToDetalhamento(Dentista dentista) {
        return new DadosDetalhamentoDentista(
                dentista.getId(),
                dentista.getNome(),
                dentista.getEmail(),
                dentista.getTelefone(),
                dentista.getCro(),
                dentista.getEspecialidade(),
                new DadosEndereco(dentista.getEndereco())
        );
    }
}
