package br.com.zupacademy.brenonoccioli.autor;

import br.com.zupacademy.brenonoccioli.autor.dto.AutorDto;
import br.com.zupacademy.brenonoccioli.autor.form.AutorForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;


    //realiza cadastro de novo autor
    @PostMapping("/cadastrar")
    @Transactional
    public ResponseEntity<AutorDto> cadastrar(@RequestBody @Valid AutorForm autorForm){
        Autor autor = autorForm.toModel();
        autorRepository.save(autor);
        return ResponseEntity.ok().body(new AutorDto(autor));
    }
}
