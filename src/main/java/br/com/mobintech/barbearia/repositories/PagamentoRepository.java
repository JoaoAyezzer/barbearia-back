package br.com.mobintech.barbearia.repositories;

import br.com.mobintech.barbearia.models.Pagamento;
import br.com.mobintech.barbearia.models.TipoPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    @Transactional(readOnly = true)
    Pagamento findByTipoPagamento(TipoPagamento tipoPagamento);
}
