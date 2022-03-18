package com.tech.barbeariaback.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    private Date prazoRecebimento;
    @Column
    @OneToMany(mappedBy = "tipoPagamento")
    private List<Pagamento> pagamentos;

}
