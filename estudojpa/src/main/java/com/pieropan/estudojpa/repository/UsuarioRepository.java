package com.pieropan.estudojpa.repository;

import com.pieropan.estudojpa.domain.Usuario;

import com.pieropan.estudojpa.dto.UsuarioDTOExemplo2;
import com.pieropan.estudojpa.repository.service.UsuarioDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value = "select u.LOGIN, u.SENHA from USUARIO u where u.NOME = 'matheus'", nativeQuery = true)
    UsuarioDTO buscarUsuario();

    @Query(nativeQuery = true)
    UsuarioDTOExemplo2 buscarUsuarioExemplo2();
}