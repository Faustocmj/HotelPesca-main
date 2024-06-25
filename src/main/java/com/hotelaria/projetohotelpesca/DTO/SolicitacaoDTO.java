package com.hotelaria.projetohotelpesca.DTO;

public class SolicitacaoDTO {

    private Integer codSolicitacao;
    private String clienteNome;
    private String colaboradorNome;
    private String dataCriacao;
    private String status;

    public SolicitacaoDTO(Integer codSolicitacao, String clienteNome, String colaboradorNome, String dataCriacao, String status) {
        this.codSolicitacao = codSolicitacao;
        this.clienteNome = clienteNome;
        this.colaboradorNome = colaboradorNome;
        this.dataCriacao = dataCriacao;
        this.status = status;
    }

    public Integer getCodSolicitacao() {
        return codSolicitacao;
    }

    public void setCodSolicitacao(Integer codSolicitacao) {
        this.codSolicitacao = codSolicitacao;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    public String getColaboradorNome() {
        return colaboradorNome;
    }

    public void setColaboradorNome(String colaboradorNome) {
        this.colaboradorNome = colaboradorNome;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
