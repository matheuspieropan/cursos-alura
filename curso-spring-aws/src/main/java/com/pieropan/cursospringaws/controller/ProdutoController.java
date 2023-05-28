package com.pieropan.cursospringaws.controller;

import com.pieropan.cursospringaws.enums.EventType;
import com.pieropan.cursospringaws.model.Produto;
import com.pieropan.cursospringaws.repository.ProdutoRepository;
import com.pieropan.cursospringaws.service.ProdutoPublicador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoPublicador produtoPublicador;

    @Autowired
    ProdutoRepository repository;

    @GetMapping
    public Iterable<Produto> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable long id) {
        Optional<Produto> optProduct = repository.findById(id);
        if (optProduct.isPresent()) {
            produtoPublicador.publicarEvento(optProduct.get(), EventType.PRODUTO_GET_ID, "Samira Lira");
            return new ResponseEntity<>(optProduct.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Produto> saveProduct(@RequestBody Produto produto) {
        Produto productCriado = repository.save(produto);
        produtoPublicador.publicarEvento(produto, EventType.PRODUTO_CRIADO, "Matheus Pieropan");
        return new ResponseEntity<>(productCriado, HttpStatus.CREATED);
    }
}