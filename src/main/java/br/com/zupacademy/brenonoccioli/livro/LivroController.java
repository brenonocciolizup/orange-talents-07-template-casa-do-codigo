package br.com.zupacademy.brenonoccioli.livro;

import br.com.zupacademy.brenonoccioli.autor.Autor;
import br.com.zupacademy.brenonoccioli.autor.AutorRepository;
import br.com.zupacademy.brenonoccioli.categoria.Categoria;
import br.com.zupacademy.brenonoccioli.categoria.CategoriaRepository;
import br.com.zupacademy.brenonoccioli.livro.dto.ListaLivroDto;
import br.com.zupacademy.brenonoccioli.livro.dto.LivroDto;
import br.com.zupacademy.brenonoccioli.livro.form.LivroForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("livros")
public class LivroController {
    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;



    @PostMapping("/cadastrar")
    @Transactional
    public ResponseEntity<LivroDto> cadastrar(@RequestBody @Valid LivroForm form){

        Livro livro = form.toModel(categoriaRepository, autorRepository);
        livroRepository.save(livro);
        return ResponseEntity.ok().body(new LivroDto(livro));
    }

    @GetMapping
    public List<ListaLivroDto> listaDeLivros(){
        List<Livro> livros = livroRepository.findAll();
        return ListaLivroDto.converter(livros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalheLivroDto> detalhesLivro(@PathVariable Long id){
        Optional<Livro> livro = livroRepository.findById(id);

        if(livro.isPresent()){
            return ResponseEntity.ok().body(new DetalheLivroDto(livro.get()));
        }
        return ResponseEntity.notFound().build();
    }
}
