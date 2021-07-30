package br.com.zupacademy.brenonoccioli.cliente.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

public class ClienteDto {
    private Long id;


    public ClienteDto(Long id){
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
