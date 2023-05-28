package com.pieropan.cursospringaws.service;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.Topic;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pieropan.cursospringaws.enums.EventType;
import com.pieropan.cursospringaws.model.Envelope;
import com.pieropan.cursospringaws.model.Produto;
import com.pieropan.cursospringaws.model.ProdutoEvento;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ProdutoPublicador {

    private static final Logger log = LoggerFactory.getLogger(ProdutoPublicador.class);

    private final AmazonSNS amazonSNS;

    private final Topic topic;

    private final ObjectMapper objectMapper;

    public ProdutoPublicador(AmazonSNS amazonSNS,
                             @Qualifier("produtoEventosTopico") Topic topic,
                             ObjectMapper objectMapper) {
        this.amazonSNS = amazonSNS;
        this.topic = topic;
        this.objectMapper = objectMapper;
    }

    public void publicarEvento(Produto produto, EventType eventType, String userName) {
        ProdutoEvento produtoEvento = new ProdutoEvento();
        produtoEvento.setProdutoId(produto.getId());
        produtoEvento.setCodigo(produtoEvento.getCodigo());
        produtoEvento.setUserName(userName);
        Envelope envelope = new Envelope();
        envelope.setEventType(eventType);
        try {
            envelope.setData(objectMapper.writeValueAsString(produto));
            amazonSNS.publish(topic.getTopicArn(), objectMapper.writeValueAsString(envelope));
        } catch (JsonProcessingException exception) {
            log.error("Falha ao converter");
        }
    }
}