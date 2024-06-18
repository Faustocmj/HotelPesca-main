package com.hotelaria.projetohotelpesca.resources;

import com.hotelaria.projetohotelpesca.entities.Colaborador;
import com.hotelaria.projetohotelpesca.services.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/colaboradores")
public class ColaboradorResource {

    @Autowired
    private ColaboradorService service;

    @PostMapping
    public ResponseEntity<Colaborador> adicionar(@RequestBody Colaborador colaborador){
        colaborador = service.adicionar(colaborador);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{cod}")
                .buildAndExpand(colaborador.getCodUsuario()).toUri();
        return ResponseEntity.created(uri).body(colaborador);
    }

    @DeleteMapping(value = "/{cod}")
    public ResponseEntity<Void> deletar(@PathVariable Integer cod){
        service.deletar(cod);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Colaborador>> buscarTodos() {
        List<Colaborador> lista = service.buscarTodos();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping(value = "/{cod}")
    public ResponseEntity<Colaborador> buscarPorCod(@PathVariable Integer cod) {
        Colaborador obj = service.buscarPorCod(cod);
        return ResponseEntity.ok().body(obj);
    }
}
