package com.hotelaria.projetohotelpesca.enums;

public enum CategoriaQuarto {
    SOLTEIRO(1),
    CASAL(2);

    private int codigo;

    private CategoriaQuarto(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public static CategoriaQuarto valueOf(int codigo) {
        for (CategoriaQuarto c : CategoriaQuarto.values()) {
            if (c.getCodigo() == codigo) {
                return c;
            }
        }
        throw new IllegalArgumentException("Código da categoria do quarto inválido");
    }
}
