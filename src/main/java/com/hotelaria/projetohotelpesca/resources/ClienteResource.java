package com.hotelaria.projetohotelpesca.resources;

import com.hotelaria.projetohotelpesca.entities.Cliente;
import com.hotelaria.projetohotelpesca.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService service;

    @GetMapping
    public ResponseEntity<List<Cliente>> buscarTodos() {
        List<Cliente> lista = service.buscarTodos();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping(value = "/{cod}")
    public ResponseEntity<Cliente> buscarPorCod(@PathVariable Integer cod) {
        Cliente obj = service.buscarPorCod(cod);
        return ResponseEntity.ok().body(obj);
    }
}
