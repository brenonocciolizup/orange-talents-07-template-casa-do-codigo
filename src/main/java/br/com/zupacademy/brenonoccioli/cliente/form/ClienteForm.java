package br.com.zupacademy.brenonoccioli.cliente.form;

import br.com.zupacademy.brenonoccioli.estadosEpaises.Estado;
import br.com.zupacademy.brenonoccioli.estadosEpaises.EstadoRepository;
import br.com.zupacademy.brenonoccioli.estadosEpaises.Pais;
import br.com.zupacademy.brenonoccioli.estadosEpaises.PaisRepository;
import br.com.zupacademy.brenonoccioli.cliente.Cliente;
import br.com.zupacademy.brenonoccioli.validator.UniqueValue;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.util.Assert;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class ClienteForm {

    @NotBlank
    @Email
    @UniqueValue(domainClass = Cliente.class, field = "email")
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank @CPF
    @UniqueValue(domainClass = Cliente.class, field = "documento")
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotNull
    private Long idPais;
    private Long idEstado;
    @NotNull
    private Integer telefone;
    @NotBlank
    private String cep;
    @Deprecated
    public ClienteForm(){}


    public ClienteForm(String email, String nome, String sobrenome, String documento, String endereco, String complemento, String cidade, Long idPais, Long idEstado, Integer telefone, String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.idPais = idPais;
        this.idEstado = idEstado;
        this.telefone = telefone;
        this.cep = cep;
    }


    public ClienteForm(String email, String nome, String sobrenome, String documento, String endereco, String complemento, String cidade, Long idPais,  Integer telefone, String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.idPais = idPais;
        this.telefone = telefone;
        this.cep = cep;
    }



    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Long getIdPais() {
        return idPais;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }



    public Cliente toModel(PaisRepository paisRepository, EstadoRepository estadoRepository){
        Optional<Pais> paisOptional = paisRepository.findById(idPais);
        Optional<Estado> estadoOptional = estadoRepository.findById(idEstado);

        if(estadoOptional == null){
            return new Cliente(this.email, this.nome, this.sobrenome, this.documento, this.endereco,
            this.complemento, this.cidade, paisOptional.get(), this.telefone, this.cep);
        } else{
            return new Cliente(this.email, this.nome, this.sobrenome, this.documento, this.endereco,
                    this.complemento, this.cidade, paisOptional.get(), estadoOptional.get(), this.telefone, this.cep);
        }
    }

    public boolean documentoValido() {
        Assert.hasLength(documento,
                "documento não preenchido");

        CPFValidator cpfValidator = new CPFValidator();
        cpfValidator.initialize(null);

        CNPJValidator cnpjValidator = new CNPJValidator();
        cnpjValidator.initialize(null);

        return cpfValidator.isValid(documento, null)
                || cnpjValidator.isValid(documento, null);
    }
}
