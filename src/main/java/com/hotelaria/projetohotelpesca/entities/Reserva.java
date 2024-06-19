package com.hotelaria.projetohotelpesca.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CodReserva")
    private Integer codReserva;

    @ManyToOne
    @JoinColumn(name = "Solicitacao_Cod")
    private Solicitacao solicitacao;

    @Column(name = "CheckIn")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy'T'HH:mm:ss")
    private LocalDateTime checkIn;

    @Column(name = "CheckOut")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy'T'HH:mm:ss")
    private LocalDateTime checkOut;

    @Column(name = "QtdDiasPesca")
    private Integer qtdDiasPesca;

    @ManyToMany
    @JoinTable(
            name = "Reserva_Quarto",
            joinColumns = @JoinColumn(name = "CodReserva"),
            inverseJoinColumns = @JoinColumn(name = "NumQuarto")
    )
    private List<Quarto> quartos = new ArrayList<>();

    public Reserva() {}

    public Reserva(Solicitacao solicitacao, LocalDateTime checkIn, LocalDateTime checkOut,
                   Integer qtdDiasPesca) {
        this.solicitacao = solicitacao;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.qtdDiasPesca = qtdDiasPesca;
    }

    public Integer getCodReserva() {
        return codReserva;
    }

    public void setCodReserva(Integer codReserva) {
        this.codReserva = codReserva;
    }

    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDateTime checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDateTime checkOut) {
        this.checkOut = checkOut;
    }

    public Integer getQtdDiasPesca() {
        return qtdDiasPesca;
    }

    public void setQtdDiasPesca(Integer qtdDiasPesca) {
        this.qtdDiasPesca = qtdDiasPesca;
    }

    public List<Quarto> getQuartos() {
        return quartos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reserva reserva)) return false;
        return Objects.equals(getCodReserva(), reserva.getCodReserva());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getCodReserva());
    }
}
