package com.pieropan.loja.service;

import com.pieropan.loja.client.FornecedorClient;
import com.pieropan.loja.dto.CompraDTO;
import com.pieropan.loja.dto.InfoPedidoDTO;
import com.pieropan.loja.model.Compra;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CompraService {
    Logger LOG = (Logger) LoggerFactory.getLogger(CompraService.class);

    @Autowired
    FornecedorClient fornecedorClient;

    public Compra realizaCompra(CompraDTO compra) {
        String estado = compra.getEndereco().getEstado();
        LOG.info("Buscando informaçoes do fornecedor de {}" + estado);
        fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());
        LOG.info("Realizando um pedido de ");
        InfoPedidoDTO pedido = fornecedorClient.realizaPedido(compra.getItens());
        Compra compraSalva = new Compra();
        compraSalva.setPedidoId(pedido.getId());
        compraSalva.setTempoPreparo(pedido.getTempoPreparo());
        compraSalva.setEnderecoDestino(compra.getEndereco().toString());
        return compraSalva;
    }
}