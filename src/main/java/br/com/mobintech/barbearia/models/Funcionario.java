package br.com.mobintech.barbearia.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity(name = "funcionarios")
public class Funcionario extends Usuario{
    private static final long serialVersionUID = 1L;
    @Column
    private Double salario;
    @Column
    private Double consumo;

    public Funcionario(String nome, String email, String senha, LocalDate dataNasc, LocalDate dataCadastro, Integer perfilDeUsuario, String telefone, Double salario, Double consumo) {
        super(nome, email, senha, dataNasc, dataCadastro, perfilDeUsuario, telefone);
        this.salario = salario;
        this.consumo = consumo;
    }

}
