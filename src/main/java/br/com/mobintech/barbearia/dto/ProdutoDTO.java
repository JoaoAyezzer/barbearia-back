package br.com.mobintech.barbearia.dto;

import br.com.mobintech.barbearia.models.Produto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ProdutoDTO implements Serializable {
    private Long id;
    private String descricao;
    private Double precoDeVenda;
    private String codBar;

    public ProdutoDTO(Produto produto) {
        this.id = produto.getId();
        this.descricao = produto.getDescricao();
        this.precoDeVenda = produto.getPrecoDeVenda();
        this.codBar = produto.getCodBar();
    }

}
