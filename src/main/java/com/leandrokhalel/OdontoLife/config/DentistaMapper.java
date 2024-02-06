package com.leandrokhalel.OdontoLife.config;

import com.leandrokhalel.OdontoLife.dto.*;
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
                new Endereco(cadastro.endereco()),
                true
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

    public static Dentista updateProperties(DadosAtualizacaoDentista data, Dentista target) {

        if(data.nome() != null) {
            target.setNome(data.nome());
        }
        if(data.telefone() != null) {
            target.setTelefone(data.telefone());
        }
        if(data.endereco()!= null) {
            target.getEndereco().updateEdereco(data.endereco());
        }

        return target;
    }
}
