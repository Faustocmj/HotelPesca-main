package com.hotelaria.projetohotelpesca.services;

import com.hotelaria.projetohotelpesca.entities.Colaborador;
import com.hotelaria.projetohotelpesca.repositories.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColaboradorService {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    public Colaborador adicionar(Colaborador colaborador) {
        return colaboradorRepository.save(colaborador);
    }

    public void deletar(Integer cod) {
        colaboradorRepository.deleteById(cod);
    }

    public List<Colaborador> buscarTodos() {
        return colaboradorRepository.findAll();
    }

    public Colaborador buscarPorCod(Integer Cod) {
        Optional<Colaborador> obj = colaboradorRepository.findById(Cod);
        return obj.get();
    }
}
