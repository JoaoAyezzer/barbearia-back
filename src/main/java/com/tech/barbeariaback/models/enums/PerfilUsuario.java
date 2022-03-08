package com.tech.barbeariaback.models.enums;


public enum PerfilUsuario {

    ADMIN(1, "Perfil de administrador"),
    FUNCIONARIO_PADRO(2, "Perfil de Funcionario padrao"),
    CLIENTE(3, "Perfil de cliente");

    private int cod;
    private String descricao;

    private PerfilUsuario(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao () {
        return descricao;
    }

    public static PerfilUsuario toEnum(Integer cod) {

        if (cod == null) {
            return null;
        }

        for (PerfilUsuario x : PerfilUsuario.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + cod);
    }

}