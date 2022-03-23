package com.tech.barbeariaback.dto;

import com.tech.barbeariaback.models.Fornecedor;
import com.tech.barbeariaback.models.Servico;
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
