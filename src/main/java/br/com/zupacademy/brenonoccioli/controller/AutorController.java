package br.com.zupacademy.brenonoccioli.controller;

import br.com.zupacademy.brenonoccioli.controller.form.AutorForm;
import br.com.zupacademy.brenonoccioli.model.Autor;
import br.com.zupacademy.brenonoccioli.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<AutorForm> cadastrar(@RequestBody @Valid AutorForm autorForm){
        Autor autor = autorForm.toModel();
        autorRepository.save(autor);
        return ResponseEntity.ok().build();
    }
}
