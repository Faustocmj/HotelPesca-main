package com.hotelaria.projetohotelpesca.services;

import com.hotelaria.projetohotelpesca.entities.Cliente;
import com.hotelaria.projetohotelpesca.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    public Cliente buscarPorCod(Integer Cod) {
        Optional<Cliente> obj = clienteRepository.findById(Cod);
        return obj.get();
    }
}
