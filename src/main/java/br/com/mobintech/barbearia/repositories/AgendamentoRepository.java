package br.com.mobintech.barbearia.repositories;

import br.com.mobintech.barbearia.models.Servico;
import br.com.mobintech.barbearia.models.Agendamento;
import br.com.mobintech.barbearia.models.Cliente;
import br.com.mobintech.barbearia.models.Barbeiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;


@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    @Transactional(readOnly = true)
    Agendamento findByCliente(Cliente cliente);
    @Transactional(readOnly = true)
    Agendamento findByProfissional(Barbeiro profissional);
    @Transactional(readOnly = true)
    Agendamento findByServico(Servico servico);
}
