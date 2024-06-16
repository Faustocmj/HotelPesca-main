package com.hotelaria.projetohotelpesca.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Clientes")
@PrimaryKeyJoinColumn(name = "CodCliente")
public class Cliente extends Usuario implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "Email")
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<Solicitacao> solicitacoes =  new ArrayList<>();

    public Cliente() {}

    public Cliente(String nome, String cpf, String rg, String endereco,
                   String telefone, String celular, String usuario, String senha,
                   LocalDate dataNascimento, String email) {
        super(null, nome, cpf, rg, endereco, telefone, celular, usuario, senha, dataNascimento);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Solicitacao> getSolicitacoes() {
        return solicitacoes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente cliente)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(email, cliente.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), email);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cliente{");
        sb.append("Código do Cliente=").append(getCodUsuario());
        sb.append(super.toString());
        sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
