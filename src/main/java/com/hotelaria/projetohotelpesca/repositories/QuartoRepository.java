package com.hotelaria.projetohotelpesca.repositories;

import com.hotelaria.projetohotelpesca.entities.Quarto;
import com.hotelaria.projetohotelpesca.enums.Disponibilidade;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface QuartoRepository extends JpaRepository<Quarto, Integer> {
    List<Quarto> findByDisponibilidade(Disponibilidade disponibilidade);
}
