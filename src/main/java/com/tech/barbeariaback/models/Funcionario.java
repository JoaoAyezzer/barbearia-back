package com.tech.barbeariaback.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.tech.barbeariaback.models.enums.PerfilUsuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "funcionarios")
@JsonTypeName("funcionario")
public class Funcionario extends Usuario{
    private static final long serialVersionUID = 1L;
    @Column
    private Double salario;
    @Column
    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    private Date dataPagamento;

}
