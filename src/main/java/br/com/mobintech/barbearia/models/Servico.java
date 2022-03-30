package br.com.mobintech.barbearia.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "servicos")
public class Servico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column
    private Double valor;
    @Column
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "HH:mm", timezone = "America/Sao_Paulo")
    private LocalTime tempoEmMinutos;
    @ElementCollection
    @CollectionTable(name = "DIAS_ATENDIMENTO")
    private Set<Integer> diasDeAtendimento = new HashSet<>();
    @JsonIgnore
    @OneToMany(mappedBy = "servico")
    private List<Agendamento> agendamentos;


    public Servico(Long id, String nome, Double valor, LocalTime tempoEmMinutos) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.tempoEmMinutos = tempoEmMinutos;
    }
}
