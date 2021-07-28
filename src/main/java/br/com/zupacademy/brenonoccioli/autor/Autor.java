package br.com.zupacademy.brenonoccioli.autor;

import br.com.zupacademy.brenonoccioli.validador.UniqueValue;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Autor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @Email @NotBlank @Column(unique = true)
    private String email;

    @Size(max=400) @NotBlank
    private String descricao;
    private LocalDateTime dataCadastro = LocalDateTime.now();

    @Deprecated
    public Autor(){}

    public Autor(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
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

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }
}
