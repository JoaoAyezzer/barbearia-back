package com.tech.barbeariaback.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.tech.barbeariaback.models.enums.PerfilUsuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "funcionarios_comissionados")
@JsonTypeName("funcionario_comissionado")
public class FuncionarioComissionado extends Usuario {
    private static final long serialVersionUID = 1L;
    @Column
    private Float percentualComissao;
    @Column
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date dataInicialComissao;
    @Column
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date dataFinalComissao;
    @Column
    private Double valorReceber;
    @Column
    @OneToMany(mappedBy = "profissional")
    private List<Agendamento> agendamentos = new ArrayList<>();

}
