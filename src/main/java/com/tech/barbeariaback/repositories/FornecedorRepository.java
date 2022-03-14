package com.tech.barbeariaback.repositories;

import com.tech.barbeariaback.models.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
    @Transactional(readOnly = true)
    Fornecedor findByEmail(String email);
}
