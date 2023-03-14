package com.pieropan.loja.client;


import com.pieropan.loja.dto.InfoFornecedorDTO;
import com.pieropan.loja.dto.InfoPedidoDTO;
import com.pieropan.loja.dto.ItemCompraDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("fornecedor")
public interface FornecedorClient {

    @RequestMapping("/info/{estado}")
    InfoFornecedorDTO getInfoPorEstado(@PathVariable String estado);

    @RequestMapping(method = RequestMethod.POST, value = "/pedido")
    InfoPedidoDTO realizaPedido(List<ItemCompraDTO> itens);
}