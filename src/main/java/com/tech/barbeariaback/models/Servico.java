package com.tech.barbeariaback.models;


import com.tech.barbeariaback.models.enums.DiasDaSemana;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
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
    private Integer tempoEmMinutos;
    @ElementCollection
    @CollectionTable(name = "DIAS_ATENDIMENTO")
    private Set<Integer> diasDeAtendimento = new HashSet<>();
    @OneToMany(mappedBy = "servico")
    private List<Agendamento> agendamentos;



    public Servico(Long id, String nome, Double valor, Integer tempoEmMinutos) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.tempoEmMinutos = tempoEmMinutos;
    }
}
