package br.com.zupacademy.brenonoccioli.estadosEpaises.form;

import br.com.zupacademy.brenonoccioli.estadosEpaises.Estado;
import br.com.zupacademy.brenonoccioli.estadosEpaises.Pais;
import br.com.zupacademy.brenonoccioli.validador.UniqueValue;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class EstadoForm {
    @NotBlank @UniqueValue(domainClass = Estado.class, field = "nome")
    private String nome;
    @NotNull
    private Long idPais;

    @Deprecated
    public EstadoForm(){}

    public EstadoForm(String nome, Long idPais){
        this.nome = nome;
        this.idPais = idPais;
    }

    public String getNome() {
        return nome;
    }

    public Long getIdPais() {
        return idPais;
    }

    //Como estamos definindo o Pais como um Optional, precisamos verificar isso no método de cadastro;
    public Estado toModel(EstadoForm form, Pais pais){
        return new Estado(form.getNome(), pais.getId());
    }
}
