package com.lojachrist.loja_camisetas.repository;

import com.lojachrist.loja_camisetas.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    // Por enquanto, deixamos vazio!
    // O JpaRepository já nos dá prontos métodos como save(), findAll(), findById(), delete(), etc.
}
