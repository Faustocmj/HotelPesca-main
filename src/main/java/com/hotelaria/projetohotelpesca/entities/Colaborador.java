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
@Table(name = "Colaboradores")
@PrimaryKeyJoinColumn(name = "CodColaborador")
public class Colaborador extends Usuario implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "Cargo")
    private String cargo;

    @Column(name = "NivelAcesso")
    private Integer nivelAcesso;

    @JsonIgnore
    @OneToMany(mappedBy = "colaborador", fetch = FetchType.LAZY)
    private List<Solicitacao> solicitacoes =  new ArrayList<>();

    public Colaborador() {}

    public Colaborador(Long codUsuario, String nome, String cpf, String rg, String endereco, String telefone,
                       String celular, String usuario, String senha, LocalDate dataNascimento, String cargo,
                       Integer nivelAcesso) {
        super(codUsuario, nome, cpf, rg, endereco, telefone, celular, usuario, senha, dataNascimento);
        this.cargo = cargo;
        this.nivelAcesso = nivelAcesso;
    }

    // public Colaborador(Usuario usuario, String cargo, Integer nivelAcesso) {
    //     super(usuario.getCodUsuario(), usuario.getNome(), usuario.getCpf(), usuario.getRg(), usuario.getEndereco(),
    //             usuario.getTelefone(), usuario.getCelular(), usuario.getUsuario(),
    //             usuario.getSenha(), usuario.getDataNascimento());
    //     this.cargo = cargo;
    //     this.nivelAcesso = nivelAcesso;
    // }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Integer getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(Integer nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    public List<Solicitacao> getSolicitacoes() {
        return solicitacoes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Colaborador that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getCargo(), that.getCargo()) && Objects.equals(getNivelAcesso(), that.getNivelAcesso());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCargo(), getNivelAcesso());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Colaborador{");
        sb.append("Código do Colaborador=").append(getCodUsuario());
        sb.append(super.toString());
        sb.append(", cargo='").append(cargo).append('\'');
        sb.append(", nivelAcesso=").append(nivelAcesso);
        sb.append('}');
        return sb.toString();
    }

}
