package com.hotelaria.projetohotelpesca.services;

import com.hotelaria.projetohotelpesca.entities.Quarto;
import com.hotelaria.projetohotelpesca.enums.Disponibilidade;
import com.hotelaria.projetohotelpesca.repositories.QuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuartoService {

    @Autowired
    private QuartoRepository quartoRepository;

    public List<Quarto> buscarTodos() {
        return quartoRepository.findAll();
    }

    public Quarto buscarPorCod(Integer Cod) {
        Optional<Quarto> obj = quartoRepository.findById(Cod);
        return obj.orElse(null); // Retorna null se o quarto não for encontrado
    }

    public void saveQuarto(Quarto quarto) {
        quartoRepository.save(quarto);
    }

    public void deleteQuarto(Integer id) {
        quartoRepository.deleteById(id);
    }

    public List<Quarto> buscarPorDisponibilidade(Disponibilidade disponibilidade) {
        return quartoRepository.findByDisponibilidade(disponibilidade);
    }
}
