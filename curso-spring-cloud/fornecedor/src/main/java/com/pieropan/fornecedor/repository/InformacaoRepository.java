package com.pieropan.fornecedor.repository;

import com.pieropan.fornecedor.model.Informacao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformacaoRepository extends CrudRepository<Informacao, Long> {
    Informacao findByEstado(String estado);
}