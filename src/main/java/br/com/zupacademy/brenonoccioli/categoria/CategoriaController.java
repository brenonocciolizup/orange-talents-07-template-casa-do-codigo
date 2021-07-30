package br.com.zupacademy.brenonoccioli.categoria;

import br.com.zupacademy.brenonoccioli.categoria.dto.CategoriaDto;
import br.com.zupacademy.brenonoccioli.categoria.form.CategoriaForm;
import br.com.zupacademy.brenonoccioli.config.validacao.CategoriaDuplicadaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepository repository;
    @Autowired
    private CategoriaDuplicadaValidator categoriaDuplicadaValidator;

    @InitBinder
    public void inicio(WebDataBinder binder){
        binder.addValidators(categoriaDuplicadaValidator);
    }

    @PostMapping("/cadastrar")
    @Transactional
    public ResponseEntity<CategoriaDto> cadastrar(@RequestBody @Valid CategoriaForm form){
        Categoria categoria = form.toModel();
        repository.save(categoria);
        return ResponseEntity.ok().body(new CategoriaDto(categoria));
    }
}
