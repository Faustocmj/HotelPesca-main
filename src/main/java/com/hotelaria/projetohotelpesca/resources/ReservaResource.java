package com.hotelaria.projetohotelpesca.resources;

import com.hotelaria.projetohotelpesca.entities.Reserva;
import com.hotelaria.projetohotelpesca.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/reservas")
public class ReservaResource {

    @Autowired
    private ReservaService service;

    @GetMapping
    public ResponseEntity<List<Reserva>> buscarTodos() {
        List<Reserva> lista = service.buscarTodos();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping(value = "/{cod}")
    public ResponseEntity<Reserva> buscarPorCod(@PathVariable Integer cod) {
        Reserva obj = service.buscarPorCod(cod);
        return ResponseEntity.ok().body(obj);
    }
}
