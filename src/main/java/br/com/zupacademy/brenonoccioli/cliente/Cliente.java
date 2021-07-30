package br.com.zupacademy.brenonoccioli.cliente;

import br.com.zupacademy.brenonoccioli.estadosEpaises.Estado;
import br.com.zupacademy.brenonoccioli.estadosEpaises.Pais;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank @Email @Column(unique = true)
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank @CPF @Column(unique = true)
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotNull @ManyToOne
    private Pais pais;
    @ManyToOne
    private Estado estado;
    @NotNull
    private Integer telefone;
    @NotBlank
    private String cep;

    @Deprecated
    public Cliente(){}

    //construtor com Pais e Estado

    public Cliente(String email, String nome, String sobrenome, String documento,
                   String endereco, String complemento, String cidade, Pais pais,
                   Estado estado, Integer telefone, String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.estado = estado;
        this.telefone = telefone;
        this.cep = cep;
    }

    //contrutor sem Estado

    public Cliente(String email, String nome, String sobrenome, String documento,
                   String endereco, String complemento, String cidade, Pais pais, Integer telefone, String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Pais getPais() {
        return pais;
    }

    public Estado getEstado() {
        return estado;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }
}
