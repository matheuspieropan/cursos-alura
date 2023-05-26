package com.pieropan.cursospringsecurity;

import com.pieropan.cursospringsecurity.entity.Usuario;
import com.pieropan.cursospringsecurity.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class CursoSpringSecurityApplication {

    @Autowired
    UsuarioRepository repository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(CursoSpringSecurityApplication.class, args);
    }

    @Bean
    void popularDB() {
        if (repository.findAll().iterator().hasNext()) {
            return;
        }
        repository.save(new Usuario(null, "matheuspieropan", passwordEncoder.encode("vascao123")));
    }
}