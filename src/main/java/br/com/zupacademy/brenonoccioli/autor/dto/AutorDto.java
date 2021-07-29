package br.com.zupacademy.brenonoccioli.autor.dto;


import br.com.zupacademy.brenonoccioli.autor.Autor;
//retorno da criação de um novo autor
public class AutorDto {

    private String nome;
    private String email;
    private String descricao;

    public AutorDto(Autor autor) {
        this.nome = autor.getNome();
        this.email = autor.getEmail();
        this.descricao = autor.getDescricao();
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
