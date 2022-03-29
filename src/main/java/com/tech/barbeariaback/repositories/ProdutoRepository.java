package com.tech.barbeariaback.repositories;

import com.tech.barbeariaback.models.Fornecedor;
import com.tech.barbeariaback.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    @Transactional(readOnly = true)
    Produto findByFornecedor(Fornecedor fornecedor);
}
