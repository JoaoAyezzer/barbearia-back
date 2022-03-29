package com.tech.barbeariaback.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tech.barbeariaback.models.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
public class ProdutoNewDTO implements Serializable {
    private Long id;
    private String descricao;
    private Double precoDeCompra;
    private Double precoDeVenda;
    private String codBar;
    private Integer QtdEmEstoque;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataCadastro;
    private String marca;
    private Long idFornecedor;

    public ProdutoNewDTO(Produto produto) {
        this.id = produto.getId();
        this.descricao = produto.getDescricao();
        this.precoDeCompra = produto.getPrecoDeCompra();
        this.precoDeVenda = produto.getPrecoDeVenda();
        this.codBar = produto.getCodBar();
        this.QtdEmEstoque = produto.getQtdEmEstoque();
        this.dataCadastro = produto.getDataCadastro();
        this.marca = produto.getMarca();
        this.idFornecedor = produto.getFornecedor().getId();
    }
}
