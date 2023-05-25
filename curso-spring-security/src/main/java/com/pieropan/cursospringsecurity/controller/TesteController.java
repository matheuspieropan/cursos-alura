package com.pieropan.cursospringsecurity.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/test")
@RestController
public class TesteController {

    @PostMapping
    public void teste(){
        System.out.println("Entrou aqui!!!");
    }
}
