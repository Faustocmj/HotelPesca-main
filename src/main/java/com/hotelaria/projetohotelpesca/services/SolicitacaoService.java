package com.hotelaria.projetohotelpesca.services;

import com.hotelaria.projetohotelpesca.entities.Cliente;
import com.hotelaria.projetohotelpesca.entities.Solicitacao;
import com.hotelaria.projetohotelpesca.repositories.SolicitacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SolicitacaoService {

    private final SolicitacaoRepository solicitacaoRepository;

    @Autowired
    public SolicitacaoService(SolicitacaoRepository solicitacaoRepository) {
        this.solicitacaoRepository = solicitacaoRepository;
    }

    public Solicitacao save(Solicitacao solicitacao) {
        return solicitacaoRepository.save(solicitacao);
    }

    public Optional<Solicitacao> buscarPorCod(Integer id) {
        return solicitacaoRepository.findById(id);
    }

    public List<Solicitacao> listarTodas() {
        return solicitacaoRepository.findAll();
    }

    public List<Solicitacao> buscarPorCliente(Cliente cliente) {
        return solicitacaoRepository.findByCliente(cliente);
    }
}
