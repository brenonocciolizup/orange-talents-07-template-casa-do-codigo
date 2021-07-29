package br.com.zupacademy.brenonoccioli.estadosEpaises;

import br.com.zupacademy.brenonoccioli.estadosEpaises.form.EstadoForm;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Estado {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @NotNull
    private Long idPais;

    public Estado(String nome, Long idPais){
        this.nome = nome;
        this.idPais = idPais;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Long getIdPais() {
        return idPais;
    }
}
