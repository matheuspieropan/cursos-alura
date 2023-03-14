package com.pieropan.loja.service;

import com.pieropan.loja.client.FornecedorClient;
import com.pieropan.loja.dto.CompraDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

@Service
public class CompraService {

    @Autowired
    FornecedorClient fornecedorClient;

    @Autowired
    DiscoveryClient discoveryClient;

    public void realizaCompra(CompraDTO compra) {
        fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());
    }
}