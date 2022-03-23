package com.tech.barbeariaback.dto;

import com.tech.barbeariaback.models.Servico;
import com.tech.barbeariaback.models.enums.DiasDaSemana;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class ServicoDTO {
    private Long id;
    private String nome;
    private Double valor;
    private Integer tempoEmMinutos;
    private Set<Integer> diasDeAtendimento = new HashSet<>();

    public ServicoDTO(Servico servico) {
        this.id = servico.getId();
        this.nome = servico.getNome();
        this.valor = servico.getValor();
        this.tempoEmMinutos = servico.getTempoEmMinutos();
        this.diasDeAtendimento = servico.getDiasDeAtendimento();
    }
    public Set<DiasDaSemana> getDiasDeAtendimento() {
        Set<DiasDaSemana> listDiasDaSemana = new HashSet<>();
        this.diasDeAtendimento.stream().forEach(dia -> listDiasDaSemana.add(DiasDaSemana.toEnum(dia)));
        return listDiasDaSemana;
    }
    public Set<Integer> pegaDiasDeAtendimento(){
        return this.diasDeAtendimento;
    }



}
