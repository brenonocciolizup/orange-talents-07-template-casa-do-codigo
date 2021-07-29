package br.com.zupacademy.brenonoccioli.estadosEpaises.dto;

import br.com.zupacademy.brenonoccioli.estadosEpaises.Estado;
import br.com.zupacademy.brenonoccioli.estadosEpaises.Pais;

import java.util.List;

public class PaisDto {

    private String nome;

    public PaisDto(Pais pais){
        this.nome = pais.getNome();
    }

    public String getNome() {
        return nome;
    }

}
