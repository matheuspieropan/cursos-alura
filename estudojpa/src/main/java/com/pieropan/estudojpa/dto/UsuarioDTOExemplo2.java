package com.pieropan.estudojpa.dto;

import lombok.Data;

@Data
public class UsuarioDTOExemplo2 {
    private Long id;
    private String senha;

    public UsuarioDTOExemplo2(Long id, String senha) {
        this.id = id;
        this.senha = senha;
    }
}