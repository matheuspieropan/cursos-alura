package com.pieropan.loja.controller;

import com.pieropan.loja.dto.CompraDTO;
import com.pieropan.loja.model.Compra;
import com.pieropan.loja.service.CompraService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/compra")
public class CompraController {

    @Autowired
    CompraService compraService;

    @PostMapping
    public Compra realizaCompra(@RequestBody CompraDTO compra) {
        return compraService.realizaCompra(compra);
    }
}