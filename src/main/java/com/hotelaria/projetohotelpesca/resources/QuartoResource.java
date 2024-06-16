package com.hotelaria.projetohotelpesca.resources;


import com.hotelaria.projetohotelpesca.entities.Quarto;

import com.hotelaria.projetohotelpesca.services.QuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/quartos")
public class QuartoResource {

    @Autowired
    private QuartoService service;

    @GetMapping
    public ResponseEntity<List<Quarto>> buscarTodos() {
        List<Quarto> lista = service.buscarTodos();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping(value = "/{cod}")
    public ResponseEntity<Quarto> buscarPorCod(@PathVariable Integer cod) {
        Quarto obj = service.buscarPorCod(cod);
        return ResponseEntity.ok().body(obj);
    }
}
