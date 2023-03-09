package com.pieropan.fornecedor.service;

import com.pieropan.fornecedor.model.Informacao;
import com.pieropan.fornecedor.repository.InformacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InformacaoService {

    @Autowired
    InformacaoRepository informacaoRepository;

    public Informacao getInformacaoPorEstado(String estado) {
        return informacaoRepository.findByEstado(estado);
    }
}