package br.com.mobintech.barbearia.dto;

import br.com.mobintech.barbearia.models.Servico;
import com.fasterxml.jackson.annotation.JsonFormat;
import br.com.mobintech.barbearia.models.enums.DiasDaSemana;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class ServicoDTO {
    private Long id;
    private String nome;
    private Double valor;
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "HH:mm")
    private LocalTime tempo;
    private Set<Integer> diasDeAtendimento = new HashSet<>();

    public ServicoDTO(Servico servico) {
        this.id = servico.getId();
        this.nome = servico.getNome();
        this.valor = servico.getValor();
        this.tempo = servico.getTempoEmMinutos();
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
