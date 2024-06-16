package com.hotelaria.projetohotelpesca.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hotelaria.projetohotelpesca.enums.Status;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Solicitacoes")
public class Solicitacao implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CodSolicitacao")
    private Integer codSolicitacao;

    @ManyToOne
    @JoinColumn(name = "Cliente_cod")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "Colaborador_cod")
    private Colaborador colaborador;

    @Column(name = "DataCriacao")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy'T'HH:mm:ss")
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @Column(name = "Status")
    private Integer status = 1;

    @OneToMany(mappedBy = "solicitacao", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Reserva> reservas = new ArrayList<>();

    public Solicitacao() {}

    public Solicitacao(Integer codSolicitacao, Cliente cliente,
                       Colaborador colaborador, LocalDateTime dataCriacao,
                       Status status) {
        this.codSolicitacao = codSolicitacao;
        this.cliente = cliente;
        this.colaborador = colaborador;
        this.dataCriacao = dataCriacao;
        this.setStatus(status);
    }

    public Integer getCodSolicitacao() {
        return codSolicitacao;
    }

    public void setCodSolicitacao(Integer codSolicitacao) {
        this.codSolicitacao = codSolicitacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Status getStatus() {
        return Status.valueOf(status);
    }

    public void setStatus(Status status) {
        if (status != null) {
            this.status = status.getValor();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Solicitacao that)) return false;
        return Objects.equals(getCodSolicitacao(), that.getCodSolicitacao());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getCodSolicitacao());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Solicitacao{");
        sb.append("codSolicitacao=").append(codSolicitacao);
        sb.append(", cliente=").append(cliente);
        sb.append(", colaborador=").append(colaborador);
        sb.append(", dataCriacao=").append(dataCriacao);
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }

}
