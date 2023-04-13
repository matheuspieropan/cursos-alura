package com.pieropan.estudojpa.domain;

import com.pieropan.estudojpa.dto.UsuarioDTOExemplo2;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.SqlResultSetMapping;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@NamedNativeQuery(name = "Usuario.buscarUsuarioExemplo2",
        query = "SELECT u.id, u.senha FROM usuario u WHERE u.nome = 'matheus'", resultSetMapping = "mapperUsuarioDTO")
@SqlResultSetMapping(name = "mapperUsuarioDTO", classes = @ConstructorResult(targetClass = UsuarioDTOExemplo2.class,
        columns = {@ColumnResult(name = "id"), @ColumnResult(name = "senha")}))
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String login;
    private String senha;
}