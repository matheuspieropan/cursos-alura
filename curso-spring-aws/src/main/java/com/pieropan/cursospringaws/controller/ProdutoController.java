package com.pieropan.cursospringaws.controller;

import com.pieropan.cursospringaws.model.Produto;
import com.pieropan.cursospringaws.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoRepository repository;

    @GetMapping
    public Iterable<Produto> findAll() {
        return repository.findAll();
    }

    @GetMapping
    public ResponseEntity<Produto> findById(@PathVariable Long id) {
        Optional<Produto> produto = repository.findById(id);
        return produto.isPresent()
                ? new ResponseEntity<>(produto.get(), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Produto> saveProduct(@RequestBody Produto produto) {
        Produto productCriado = repository.save(produto);
        return new ResponseEntity<>(productCriado, HttpStatus.CREATED);
    }
}