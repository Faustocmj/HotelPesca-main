package com.hotelaria.projetohotelpesca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/painel")
public class PainelController {

    @GetMapping("/colaborador")
    public String mostrarPainelColab(@RequestParam("colaboradorId") Integer colaboradorId, Model model) {
        model.addAttribute("colaboradorId", colaboradorId);
        return "painelcolaborador";
    }

    @GetMapping("/cliente")
    public String mostrarPainelClie(@RequestParam("clienteId") Integer clienteId, Model model) {
        model.addAttribute("clienteId", clienteId);
        return "painelcliente";
    }
}
