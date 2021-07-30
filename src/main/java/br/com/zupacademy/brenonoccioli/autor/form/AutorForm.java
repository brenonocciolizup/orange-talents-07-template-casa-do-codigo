package br.com.zupacademy.brenonoccioli.autor.form;


import br.com.zupacademy.brenonoccioli.autor.Autor;
import br.com.zupacademy.brenonoccioli.validator.UniqueValue;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorForm {
    @NotBlank
    private String nome;
    @NotBlank @Email @Column(unique = true) @UniqueValue(domainClass = Autor.class, field = "email")
    private String email;
    @NotBlank @Size(max=400)
    private String descricao;


    public AutorForm(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    //converte de AutoForm para Autor
    public Autor toModel() {
        return new Autor(this.nome, this.email, this.descricao);
    }

}
