package br.com.mobintech.barbearia.dto;

import br.com.mobintech.barbearia.models.Fornecedor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class FornecedorDTO implements Serializable {
    private  Long id;
    private  String nome;
    private  String telefone;
    private  String email;

    public FornecedorDTO(Fornecedor fornecedor){
        this.id = fornecedor.getId();
        this.nome = fornecedor.getNome();
        this.telefone = fornecedor.getTelefone();
        this.email = fornecedor.getEmail();
    }

}
