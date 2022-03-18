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
@AllArgsConstructor
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
    private List<Agendamento> agendamentos = new ArrayList<>();

    public Set<DiasDaSemana> getDiasDeAtendimento() {
        Set<DiasDaSemana> listDiasDaSemana = new HashSet<>();
        this.diasDeAtendimento.stream().forEach(dia -> listDiasDaSemana.add(DiasDaSemana.toEnum(dia)));
        return listDiasDaSemana;
    }

    public void setDiasDeAtendimento(Set<DiasDaSemana> diasDeAtendimento) {
        diasDeAtendimento.stream().forEach(dia -> this.diasDeAtendimento.add(dia.getCod()));
    }
}
