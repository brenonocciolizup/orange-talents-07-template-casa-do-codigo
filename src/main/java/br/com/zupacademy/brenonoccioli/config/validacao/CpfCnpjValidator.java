package br.com.zupacademy.brenonoccioli.config.validacao;

import br.com.zupacademy.brenonoccioli.cliente.form.ClienteForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CpfCnpjValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return ClienteForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        ClienteForm form = (ClienteForm) o;
        if(!form.documentoValido()){
            errors.rejectValue("documento", null, "envie um documento válido");
        }

    }
}
