package com.pieropan.fornecedor.controller;

import com.pieropan.fornecedor.model.Informacao;
import com.pieropan.fornecedor.service.InformacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/info")
public class InformacaoController {

    @Autowired
    InformacaoService informacaoService;

    @GetMapping(value = "/{estado}")
    public Informacao getInformacaoPorEstado(@PathVariable String estado){
        return informacaoService.getInformacaoPorEstado(estado);
    }
}