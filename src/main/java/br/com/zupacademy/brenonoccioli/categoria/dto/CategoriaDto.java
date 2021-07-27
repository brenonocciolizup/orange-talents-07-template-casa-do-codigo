package br.com.zupacademy.brenonoccioli.categoria.dto;

import br.com.zupacademy.brenonoccioli.categoria.Categoria;

public class CategoriaDto {
    private String nome;

    public CategoriaDto(Categoria categoria){
        this.nome = categoria.getNome();
    }

    public String getNome() {
        return nome;
    }
}
