package br.com.zupacademy.brenonoccioli.livro.form;

import br.com.zupacademy.brenonoccioli.autor.Autor;
import br.com.zupacademy.brenonoccioli.categoria.Categoria;
import br.com.zupacademy.brenonoccioli.livro.Livro;
import br.com.zupacademy.brenonoccioli.validador.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;


public class LivroForm {

    @NotBlank
    @UniqueValue(domainClass = Livro.class, field = "titulo")
    private String titulo;
    @NotBlank @Size(max=500)
    private String resumo;
    @NotBlank
    private String sumario;
    @NotNull @Min(value=20)
    private BigDecimal preco;
    @NotNull @Min(value=100)
    private int numeroPaginas;
    @NotBlank @UniqueValue(domainClass = Livro.class, field = "isbn")
    private String isbn;
    @Future
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;
    @NotNull
    private Long categoriaId;
    @NotNull
    private Long autorId;

    public LivroForm(String titulo, String resumo, String sumario, BigDecimal preco, int numeroPaginas, String isbn, Long categoriaId, Long autorId) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.categoriaId = categoriaId;
        this.autorId = autorId;
    }


    public Long getCategoriaId() {
        return categoriaId;
    }

    public Long getAutorId() {
        return autorId;
    }
    // Setter para que o Jackson consiga realizar a desserialização; não encontrei outra forma de resolver isso
    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    //Passei os dois objetos como parâmetros para conseguir pegar o objeto pelo get() do Optional
    public Livro toModel(Categoria categoria, Autor autor) {
        return new Livro(titulo, resumo, sumario, preco, numeroPaginas, isbn, dataPublicacao, categoria, autor);
    }
}
