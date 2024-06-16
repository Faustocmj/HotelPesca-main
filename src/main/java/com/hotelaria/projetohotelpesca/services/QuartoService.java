package com.hotelaria.projetohotelpesca.services;

import com.hotelaria.projetohotelpesca.entities.Quarto;
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
        return obj.get();
    }
}
