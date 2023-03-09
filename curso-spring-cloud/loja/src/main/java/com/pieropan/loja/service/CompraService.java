package com.pieropan.loja.service;

import com.pieropan.loja.dto.CompraDTO;
import com.pieropan.loja.dto.InfoFornecedorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CompraService {

    @Autowired
    RestTemplate restTemplate;

    public void realizaCompra(CompraDTO compra) {
        ResponseEntity<InfoFornecedorDTO> exchange =
                restTemplate.exchange("http://fornecedor/info/" + compra.getEndereco().getEstado(),
                      HttpMethod.GET, null, InfoFornecedorDTO.class);
        System.out.printf(exchange.getBody().getEndereco());
    }
}