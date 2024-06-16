package com.hotelaria.projetohotelpesca.enums;

public enum Status {
    FECHADO(0),
    ABERTO(1),
    APROVADO(2),
    NEGADO(3);

    private int valor;

    private Status(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public static Status valueOf(int valor) {
        for (Status status : Status.values()) {
            if (status.getValor() == valor) {
                return status;
            }
        }
        throw new IllegalArgumentException("Valor de status inválido");
    }
}
