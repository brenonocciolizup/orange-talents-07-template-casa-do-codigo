package br.com.zupacademy.brenonoccioli.estadosEpaises.dto;

import br.com.zupacademy.brenonoccioli.estadosEpaises.Estado;
import br.com.zupacademy.brenonoccioli.estadosEpaises.Pais;

public class EstadoDto {
    private String nome;
    private String nomePais;

    public EstadoDto(Estado estado, Pais pais){
        this.nome = estado.getNome();
        this.nomePais = pais.getNome();
    }

    public String getNome() {
        return nome;
    }

    public String getNomePais() {
        return nomePais;
    }
}
