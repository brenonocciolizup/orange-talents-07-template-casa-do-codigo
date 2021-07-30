package br.com.zupacademy.brenonoccioli.categoria.form;

import br.com.zupacademy.brenonoccioli.categoria.Categoria;
import br.com.zupacademy.brenonoccioli.validator.UniqueValue;

import javax.validation.constraints.NotBlank;

public class CategoriaForm {
    @NotBlank @UniqueValue(domainClass = Categoria.class, field = "nome")
    private String nome;

    public String getNome() {
        return nome;
    }

    public Categoria toModel() {
        return new Categoria(this.nome);
    }

}
