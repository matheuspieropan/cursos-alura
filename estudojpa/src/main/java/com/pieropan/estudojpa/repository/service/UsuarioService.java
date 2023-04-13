package com.pieropan.estudojpa.repository.service;

import com.pieropan.estudojpa.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    public UsuarioDTO buscarUsuario() {
        repository.buscarUsuarioExemplo2();
        return repository.buscarUsuario();
    }
}