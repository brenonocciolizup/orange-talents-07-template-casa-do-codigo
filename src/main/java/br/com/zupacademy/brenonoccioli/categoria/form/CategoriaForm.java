package br.com.zupacademy.brenonoccioli.categoria.form;

import br.com.zupacademy.brenonoccioli.categoria.Categoria;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

public class CategoriaForm {
    @NotBlank
    private String nome;

    public String getNome() {
        return nome;
    }

    public Categoria toModel() {
        return new Categoria(this.nome);
    }

}
