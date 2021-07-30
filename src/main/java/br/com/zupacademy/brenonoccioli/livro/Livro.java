package br.com.zupacademy.brenonoccioli.livro;

import br.com.zupacademy.brenonoccioli.autor.Autor;
import br.com.zupacademy.brenonoccioli.categoria.Categoria;
import com.fasterxml.jackson.annotation.JsonFormat;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Livro {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String titulo;
    @NotBlank @Size(max=500)
    private String resumo;
    @NotBlank
    private String sumario;
    @NotNull @Min(value=20)
    private BigDecimal preco;
    @NotNull @Min(value=100)
    private Integer numeroPaginas;
    @NotBlank
    private String isbn;

    @Future
    @NotNull
    private LocalDate dataPublicacao;
    @NotNull @ManyToOne
    private Categoria categoria;
    @NotNull @ManyToOne
    private Autor autor;

    @Deprecated
    public Livro(){}

    public Livro(String titulo, String resumo, String sumario, BigDecimal preco, Integer numeroPaginas, String isbn, LocalDate dataPublicacao, Categoria categoria, Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }



}
