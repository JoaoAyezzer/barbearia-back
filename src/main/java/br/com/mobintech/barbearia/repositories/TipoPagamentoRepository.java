package br.com.mobintech.barbearia.repositories;

import br.com.mobintech.barbearia.models.TipoPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPagamentoRepository extends JpaRepository<TipoPagamento, Long> {

}
