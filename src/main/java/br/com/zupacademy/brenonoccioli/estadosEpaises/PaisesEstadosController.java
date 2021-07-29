package br.com.zupacademy.brenonoccioli.estadosEpaises;

import br.com.zupacademy.brenonoccioli.estadosEpaises.dto.EstadoDto;
import br.com.zupacademy.brenonoccioli.estadosEpaises.dto.PaisDto;
import br.com.zupacademy.brenonoccioli.estadosEpaises.form.EstadoForm;
import br.com.zupacademy.brenonoccioli.estadosEpaises.form.PaisForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("pais-e-estado")
public class PaisesEstadosController {

    @Autowired
    private PaisRepository paisRepository;
    @Autowired
    private EstadoRepository estadoRepository;


    @PostMapping("/novo-pais")
    public ResponseEntity<PaisDto> cadastraPais(@RequestBody @Valid PaisForm form){
        Pais pais = new Pais(form.getNome());
        paisRepository.save(pais);
        return ResponseEntity.ok(new PaisDto(pais));
    }

    @PostMapping("/novo-estado")
    public ResponseEntity<EstadoDto> cadastraEstado(@RequestBody @Valid EstadoForm form){
        Optional<Pais> pais = paisRepository.findById(form.getIdPais());
        if(pais.isEmpty()){
            return ResponseEntity.badRequest().build();
        }

        Estado estado = form.toModel(form, pais.get());
        estadoRepository.save(estado);
        return ResponseEntity.ok().body(new EstadoDto(estado, pais.get()));
    }



}
