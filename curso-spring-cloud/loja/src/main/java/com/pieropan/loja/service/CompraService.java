package com.pieropan.loja.service;

import com.pieropan.loja.client.FornecedorClient;
import com.pieropan.loja.dto.CompraDTO;
import com.pieropan.loja.dto.InfoPedidoDTO;
import com.pieropan.loja.model.Compra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

@Service
public class CompraService {

    @Autowired
    FornecedorClient fornecedorClient;

    @Autowired
    DiscoveryClient discoveryClient;

    public Compra realizaCompra(CompraDTO compra) {
        fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());
        InfoPedidoDTO pedido = fornecedorClient.realizaPedido(compra.getItens());
        Compra compraSalva = new Compra();
        compraSalva.setPedidoId(pedido.getId());
        compraSalva.setTempoPreparo(pedido.getTempoPreparo());
        compraSalva.setEnderecoDestino(compra.getEndereco().toString());
        return compraSalva;
    }
}