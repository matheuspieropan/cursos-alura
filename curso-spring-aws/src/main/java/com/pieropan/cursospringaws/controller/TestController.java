package com.pieropan.cursospringaws.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class TestController {

    final Logger LOG = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/dog/{dog}")
    public ResponseEntity<?> dogTest(@PathVariable String dog) {

        LOG.info("Teste controller - name: {}", dog);
        return ResponseEntity.ok("Dog: " + dog);
    }
}