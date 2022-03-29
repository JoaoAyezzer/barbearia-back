package com.tech.barbeariaback.repositories;

import com.tech.barbeariaback.models.Agendamento;
import com.tech.barbeariaback.models.Cliente;
import com.tech.barbeariaback.models.Barbeiro;
import com.tech.barbeariaback.models.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    @Transactional(readOnly = true)
    Agendamento findByCliente(Cliente cliente);
    @Transactional(readOnly = true)
    Agendamento findByProfissional(Barbeiro profissional);
    @Transactional(readOnly = true)
    Agendamento findByServico(Servico servico);
}
