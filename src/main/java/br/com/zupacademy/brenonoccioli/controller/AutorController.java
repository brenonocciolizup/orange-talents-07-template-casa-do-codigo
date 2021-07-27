package br.com.zupacademy.brenonoccioli.controller;

import br.com.zupacademy.brenonoccioli.controller.dto.AutorDto;
import br.com.zupacademy.brenonoccioli.controller.form.AutorForm;
import br.com.zupacademy.brenonoccioli.model.Autor;
import br.com.zupacademy.brenonoccioli.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private ValidaEmailDuplicadoValidator validaEmailDuplicadoValidator;

    @InitBinder
    public void inicio(WebDataBinder binder){
        binder.addValidators(validaEmailDuplicadoValidator);
    }


    //realiza cadastro de novo autor
    @PostMapping("/cadastrar")
    @Transactional
    public ResponseEntity<AutorDto> cadastrar(@RequestBody @Valid AutorForm autorForm){
        Autor autor = autorForm.toModel();
        autorRepository.save(autor);
        return ResponseEntity.ok().body(new AutorDto(autor));
    }
}
