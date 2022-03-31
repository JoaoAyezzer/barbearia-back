package br.com.mobintech.barbearia.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tipos_pagamentos")
public class TipoPagamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column
    private Float taxaRecebimento;
    @Column
    private Long prazoRecebimento;
    @Column
    @OneToMany(mappedBy = "tipoPagamento")
    private List<Pagamento> pagamentos;

    public TipoPagamento(Long id, String nome, Float taxaRecebimento, Long prazoRecebimento) {
        this.id = id;
        this.nome = nome;
        this.taxaRecebimento = taxaRecebimento;
        this.prazoRecebimento = prazoRecebimento;
    }
}
