package br.com.mobintech.barbearia.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "barbeiro")
public class Barbeiro extends Usuario {
    private static final long serialVersionUID = 1L;
    @Column
    private Integer percentualComissao;
    @Column
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern="dd-MM-yyyy", timezone = "America/Sao_Paulo")
    private LocalDate dataInicialComissao;
    @Column
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern="dd-MM-yyyy", timezone = "America/Sao_Paulo")
    private LocalDate dataFinalComissao;
    @Column
    private Double valorReceber;
    @JsonIgnore
    @Column
    @OneToMany(mappedBy = "profissional")
    private List<Agendamento> agendamentos = new ArrayList<>();

    public Barbeiro(String nome,
                    String email,
                    String senha,
                    LocalDate dataNasc,
                    LocalDate dataCadastro,
                    Integer perfilDeUsuario,
                    String telefone,
                    Integer percentualComissao,
                    LocalDate dataInicialComissao,
                    LocalDate dataFinalComissao) {
        super(nome, email, senha, dataNasc, dataCadastro, perfilDeUsuario, telefone);
        this.percentualComissao = percentualComissao;
        this.dataInicialComissao = dataInicialComissao;
        this.dataFinalComissao = dataFinalComissao;
    }

}
