package br.com.zupacademy.brenonoccioli.categoria.form;

import br.com.zupacademy.brenonoccioli.categoria.Categoria;
import br.com.zupacademy.brenonoccioli.validador.UniqueValue;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
