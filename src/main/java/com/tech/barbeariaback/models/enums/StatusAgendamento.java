package com.tech.barbeariaback.models.enums;


public enum StatusAgendamento {

    AGENDADO(1, "Agendado"),
    FINALIZADO(2, "Finalizado"),
    ATRASADO(3, "Atrasado"),
    CANCELADO(4, "Cancelado");

    private int cod;
    private String descricao;

    private StatusAgendamento(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao () {
        return descricao;
    }

    public static StatusAgendamento toEnum(Integer cod) {

        if (cod == null) {
            return null;
        }

        for (StatusAgendamento x : StatusAgendamento.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + cod);
    }

}