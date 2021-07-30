package br.com.zupacademy.brenonoccioli.cliente;

import br.com.zupacademy.brenonoccioli.cliente.dto.ClienteDto;
import br.com.zupacademy.brenonoccioli.estadosEpaises.EstadoRepository;
import br.com.zupacademy.brenonoccioli.estadosEpaises.PaisRepository;
import br.com.zupacademy.brenonoccioli.cliente.form.ClienteForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    PaisRepository paisRepository;
    @Autowired
    EstadoRepository estadoRepository;

    @PostMapping("/cadastrar")
    public ResponseEntity<ClienteDto> cadastraCliente(@RequestBody @Valid ClienteForm form){
        Cliente cliente = form.toModel(paisRepository,estadoRepository);
        clienteRepository.save(cliente);

        return ResponseEntity.ok().body(new ClienteDto(cliente.getId()));
    }
}
