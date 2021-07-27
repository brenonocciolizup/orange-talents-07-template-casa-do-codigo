package br.com.zupacademy.brenonoccioli.controller;

import br.com.zupacademy.brenonoccioli.controller.form.AutorForm;
import br.com.zupacademy.brenonoccioli.model.Autor;
import br.com.zupacademy.brenonoccioli.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;


@Component
public class ValidaEmailDuplicadoValidator implements Validator {
    @Autowired
    private AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return AutorForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        AutorForm form = (AutorForm) target;
        Optional<Autor> email = autorRepository.findByEmail(form.getEmail());

        if(email.isPresent()){
            errors.rejectValue("email", null, "Já existe um e-mail igual registrado: " + form.getEmail());
        }
    }
}
