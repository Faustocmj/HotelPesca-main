package com.hotelaria.projetohotelpesca.repositories;

import com.hotelaria.projetohotelpesca.entities.Solicitacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Integer> {
}
