package br.com.zupacademy.brenonoccioli.controller.form;


import br.com.zupacademy.brenonoccioli.model.Autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorForm {
    @NotBlank
    private String nome;
    @NotBlank @Email
    private String email;
    @NotBlank @Size(max=400)
    private String descricao;

    public AutorForm(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    //converte de AutoForm para Autor
    public Autor toModel() {
        return new Autor(this.nome, this.email, this.descricao);
    }
}
