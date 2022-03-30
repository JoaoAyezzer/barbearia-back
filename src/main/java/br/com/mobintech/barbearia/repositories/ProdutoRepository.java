package br.com.mobintech.barbearia.repositories;

import br.com.mobintech.barbearia.models.Fornecedor;
import br.com.mobintech.barbearia.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    @Transactional(readOnly = true)
    Produto findByFornecedor(Fornecedor fornecedor);
}
