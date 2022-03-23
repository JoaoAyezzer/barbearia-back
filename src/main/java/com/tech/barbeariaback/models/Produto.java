package com.tech.barbeariaback.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "produtos")
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String descricao;
    @Column
    private Double precoDeCompra;
    @Column
    private Double precoDeVenda;
    @Column
    private String codBar;
    @Column
    private Integer QtdEmEstoque;
    @Column
    @JsonFormat(pattern="dd/MM/yyyy HH:mm", timezone = "America/Sao_Paulo")
    private Date dataCadastro;
    @Column
    private String marca;
    @ManyToOne
    @JoinColumn(name = "FORNECEDOR_ID")
    private Fornecedor fornecedor;
    @ManyToMany(mappedBy="produtos")
    private List<Agendamento> agendamentos;

}
