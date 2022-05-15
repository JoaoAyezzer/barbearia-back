package br.com.mobintech.barbearia.repositories;

import br.com.mobintech.barbearia.models.Servico;
import br.com.mobintech.barbearia.models.Agendamento;
import br.com.mobintech.barbearia.models.Cliente;
import br.com.mobintech.barbearia.models.Barbeiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;


@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    @Transactional(readOnly = true)
    Optional<Agendamento> findByCliente(Cliente cliente);
    @Transactional(readOnly = true)
    Optional<Agendamento> findByProfissional(Barbeiro profissional);
    @Transactional(readOnly = true)
    Optional<Agendamento> findByServico(Servico servico);
    @Transactional(readOnly = true)
    Optional<Agendamento> findByData(LocalDate data);
}
