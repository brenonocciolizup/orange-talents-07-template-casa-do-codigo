package br.com.zupacademy.brenonoccioli.livro.dto;

import br.com.zupacademy.brenonoccioli.livro.Livro;

import java.util.ArrayList;
import java.util.List;


public class ListaLivroDto {

    private Long id;
    private String titulo;

    public ListaLivroDto(Livro l) {
        this.id = l.getId();
        this.titulo = l.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public static List<ListaLivroDto> converter(List<Livro> livros){
        List<ListaLivroDto> listaDto = new ArrayList<>();
        for(Livro livro : livros){
            ListaLivroDto dto = new ListaLivroDto(livro);
            listaDto.add(dto);
        }
        return listaDto;
    }

}
