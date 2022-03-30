package br.com.mobintech.barbearia.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import br.com.mobintech.barbearia.models.enums.PerfilUsuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy= InheritanceType.JOINED)
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    @JsonIgnore
    private String senha;
    @Column
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern="dd-MM-yyyy", timezone = "America/Sao_Paulo")
    private LocalDate dataNasc;
    @Column
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern="dd-MM-yyyy", timezone = "America/Sao_Paulo")
    private LocalDate dataCadastro;
    @Column
    private Integer perfilDeUsuario;
    @Column
    private String telefone;
    @Column
    private String urlAvatar;

    public PerfilUsuario getPerfilDeUsuario() {
        return PerfilUsuario.toEnum(this.perfilDeUsuario);
    }
    public void setPerfilDeUsuario(PerfilUsuario perfilDeUsuario) {
        this.perfilDeUsuario = perfilDeUsuario.getCod();
    }

    public Usuario(String nome, String email, String senha, LocalDate dataNasc, LocalDate dataCadastro, Integer perfilDeUsuario, String telefone) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataNasc = dataNasc;
        this.dataCadastro = dataCadastro;
        this.perfilDeUsuario = perfilDeUsuario;
        this.telefone = telefone;
    }

}
