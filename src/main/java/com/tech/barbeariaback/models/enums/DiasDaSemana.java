package com.tech.barbeariaback.models.enums;


public enum DiasDaSemana {

    DOMINGO(1, "Domingo"),
    SEGUNDA(2, "Segunda-feira"),
    TERCA(3, "Terça-feira"),
    QUARTA(4, "Quarta-Feira"),
    QUINTA(5, "Quinta-Feira"),
    SEXTA(6, "Sexta-Feira"),
    SABADO(7, "Sabado");

    private int cod;
    private String descricao;

    private DiasDaSemana(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao () {
        return descricao;
    }

    public static DiasDaSemana toEnum(Integer cod) {

        if (cod == null) {
            return null;
        }

        for (DiasDaSemana x : DiasDaSemana.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + cod);
    }

}