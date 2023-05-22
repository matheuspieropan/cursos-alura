package com.pieropan.cursospringaws.repository;

import com.pieropan.cursospringaws.model.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {
    Optional<Produto> findByCodigo(String codigo);
}