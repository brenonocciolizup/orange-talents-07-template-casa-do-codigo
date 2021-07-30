package br.com.zupacademy.brenonoccioli.config.validacao;

import br.com.zupacademy.brenonoccioli.autor.form.AutorForm;
import br.com.zupacademy.brenonoccioli.categoria.Categoria;
import br.com.zupacademy.brenonoccioli.categoria.CategoriaRepository;
import br.com.zupacademy.brenonoccioli.categoria.form.CategoriaForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class CategoriaDuplicadaValidator implements Validator {
    @Autowired
    private CategoriaRepository repository;

    @Override
    public boolean supports(Class<?> aClass) {
        return CategoriaForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        CategoriaForm form = (CategoriaForm) o;
        Optional<Categoria> categoria = repository.findByNome(form.getNome());

        if(categoria.isPresent()){
            errors.rejectValue("nome", null, "categoria já existente");
        }
    }
}
