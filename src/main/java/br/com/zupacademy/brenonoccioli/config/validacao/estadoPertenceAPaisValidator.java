package br.com.zupacademy.brenonoccioli.config.validacao;

import br.com.zupacademy.brenonoccioli.cliente.form.ClienteForm;
import br.com.zupacademy.brenonoccioli.estadosEpaises.Estado;
import br.com.zupacademy.brenonoccioli.estadosEpaises.EstadoRepository;
import br.com.zupacademy.brenonoccioli.estadosEpaises.Pais;
import br.com.zupacademy.brenonoccioli.estadosEpaises.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class estadoPertenceAPaisValidator implements Validator {
    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private EstadoRepository estadoRepository;

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

        Pais pais = paisRepository.findById(form.getIdPais()).get();
        Estado estado = estadoRepository.findById(form.getIdEstado()).get();

        if(!estado.getIdPais().equals(pais.getId())){
            errors.rejectValue("idEstado", null, "selecione o país correto referente ao estado");
        }

    }
}
