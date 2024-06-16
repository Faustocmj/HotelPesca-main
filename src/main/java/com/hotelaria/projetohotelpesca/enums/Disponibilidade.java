package com.hotelaria.projetohotelpesca.enums;

public enum Disponibilidade {
    INDISPONIVEL(0),
    DISPONIVEL(1),
    MANUTENCAO(2);

    private int estado;

    private Disponibilidade(int estado) {
        this.estado = estado;
    }

    public int getEstado() {
        return estado;
    }

    public static Disponibilidade valueOf(int estado) {
        for (Disponibilidade disp : Disponibilidade.values()) {
            if (disp.getEstado() == estado) {
                return disp;
            }
        }
        throw new IllegalArgumentException("Estado de disponibilidade inválido");
    }
}
