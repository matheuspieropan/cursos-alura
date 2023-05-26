package com.pieropan.cursospringsecurity.security.service;

import com.pieropan.cursospringsecurity.entity.Usuario;
import com.pieropan.cursospringsecurity.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) {

        Usuario usuario = repository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("Usuário não encontrado!"));

        return usuario;
    }
}