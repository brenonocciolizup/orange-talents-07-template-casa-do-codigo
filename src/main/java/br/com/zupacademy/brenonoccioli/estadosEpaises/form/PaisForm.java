package br.com.zupacademy.brenonoccioli.estadosEpaises.form;

import br.com.zupacademy.brenonoccioli.estadosEpaises.Pais;
import br.com.zupacademy.brenonoccioli.validador.UniqueValue;

import javax.validation.constraints.NotBlank;

public class PaisForm {
    @NotBlank @UniqueValue(domainClass = Pais.class, field = "nome")
    private String nome;


    @Deprecated
    public PaisForm(){}

    public PaisForm (String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
