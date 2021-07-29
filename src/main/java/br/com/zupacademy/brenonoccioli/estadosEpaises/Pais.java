package br.com.zupacademy.brenonoccioli.estadosEpaises;

import br.com.zupacademy.brenonoccioli.estadosEpaises.form.PaisForm;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Pais {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @OneToMany
    private List<Estado> estados;

    public Pais(){}

    Pais(String nome){
        this.nome = nome;
    }
    public Pais(String nome, Estado estado){
        this.nome = nome;
        this.estados.add(estado);
    }


    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Estado> getEstados() {
        return estados;
    }
}
