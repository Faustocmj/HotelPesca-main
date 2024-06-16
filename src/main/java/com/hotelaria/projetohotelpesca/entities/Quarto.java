package com.hotelaria.projetohotelpesca.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hotelaria.projetohotelpesca.enums.CategoriaQuarto;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Quartos")
public class Quarto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "NumQuarto")
    private Integer numQuarto;

    @Column(name = "Categoria")
    private Integer categoria;

    @JsonIgnore
    @ManyToMany(mappedBy = "quartos")
    private List<Reserva> reservas = new ArrayList<>();

    public Quarto() {}

    public Quarto(Integer numQuarto, CategoriaQuarto categoria) {
        this.numQuarto = numQuarto;
        this.setCategoria(categoria);
    }

    public Integer getNumQuarto() {
        return numQuarto;
    }

    public void setNumQuarto(Integer numQuarto) {
        this.numQuarto = numQuarto;
    }

    public CategoriaQuarto getCategoria() {
        return CategoriaQuarto.valueOf(categoria);
    }

    public void setCategoria(CategoriaQuarto categoria) {
        this.categoria = categoria.getCodigo();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Quarto quarto)) return false;
        return Objects.equals(getNumQuarto(), quarto.getNumQuarto());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getNumQuarto());
    }
}
