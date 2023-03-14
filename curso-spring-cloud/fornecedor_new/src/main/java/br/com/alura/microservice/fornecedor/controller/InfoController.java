package br.com.alura.microservice.fornecedor.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.microservice.fornecedor.model.InfoFornecedor;
import br.com.alura.microservice.fornecedor.service.InfoService;

import java.util.logging.Logger;

@RestController
@RequestMapping("/info")
public class InfoController {
	Logger LOG = (Logger) LoggerFactory.getLogger(InfoController.class);

	@Autowired
	private InfoService infoService;
	
	@RequestMapping("/{estado}")
	public InfoFornecedor getInfoPorEstado(@PathVariable String estado) {
		LOG.info("Recebido pedido de informações do fornecedor " + estado);
		return infoService.getInfoPorEstado(estado);
	}
}
