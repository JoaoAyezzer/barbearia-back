package com.tech.barbeariaback.models;


import com.tech.barbeariaback.models.enums.DiasDaSemana;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Servico implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private Double valor;
    private Integer tempoEmMinutos;
    private List<Integer> diasDeAtendimento;
    private List<Agendamento> agendamentos = new ArrayList<>();

    public Servico() {

    }

    public Servico(Long id, String nome, Double valor, Integer tempoEmMinutos) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.tempoEmMinutos = tempoEmMinutos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getTempoEmMinutos() {
        return tempoEmMinutos;
    }

    public void setTempoEmMinutos(Integer tempoEmMinutos) {
        this.tempoEmMinutos = tempoEmMinutos;
    }

    public List<DiasDaSemana> getDiasDeAtendimento() {
        List<DiasDaSemana> listDiasDaSemana = new ArrayList<>();
        this.diasDeAtendimento.stream().forEach(dia -> listDiasDaSemana.add(DiasDaSemana.toEnum(dia)));
        return listDiasDaSemana;
    }

    public void setDiasDeAtendimento(List<DiasDaSemana> diasDeAtendimento) {
        diasDeAtendimento.stream().forEach(dia -> this.diasDeAtendimento.add(dia.getCod()));
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Servico servico = (Servico) o;
        return id.equals(servico.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Servico{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", valor=" + valor +
                ", tempoEmMinutos=" + tempoEmMinutos +
                ", diasDeAtendimento=" + getDiasDeAtendimento() +
                ", agendamentos=" + agendamentos +
                '}';
    }
}
