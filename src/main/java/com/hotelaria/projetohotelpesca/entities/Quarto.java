package com.hotelaria.projetohotelpesca.entities;

import com.hotelaria.projetohotelpesca.enums.CategoriaQuarto;
import com.hotelaria.projetohotelpesca.enums.Disponibilidade;
import com.hotelaria.projetohotelpesca.converters.CategoriaQuartoConverter;
import com.hotelaria.projetohotelpesca.converters.DisponibilidadeConverter;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Quartos")
public class Quarto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "NumQuarto")
    private Integer numQuarto;

    @Convert(converter = CategoriaQuartoConverter.class)
    @Column(name = "Categoria")
    private CategoriaQuarto categoria;

    @Convert(converter = DisponibilidadeConverter.class)
    @Column(name = "Disponibilidade")
    private Disponibilidade disponibilidade;

    // @JsonIgnore
    // @ManyToMany(mappedBy = "quartos")
    // private List<Reserva> reservas = new ArrayList<>();

    public Quarto() {}

    public Quarto(Integer numQuarto, CategoriaQuarto categoria, Disponibilidade disponibilidade) {
        this.numQuarto = numQuarto;
        this.categoria = categoria;
        this.disponibilidade = disponibilidade;
    }

    public Integer getNumQuarto() {
        return numQuarto;
    }

    public void setNumQuarto(Integer numQuarto) {
        this.numQuarto = numQuarto;
    }

    public CategoriaQuarto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaQuarto categoria) {
        this.categoria = categoria;
    }

    public Disponibilidade getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Disponibilidade disponibilidade) {
        this.disponibilidade = disponibilidade;
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
