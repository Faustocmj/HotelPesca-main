package com.hotelaria.projetohotelpesca.controller;

import com.hotelaria.projetohotelpesca.entities.Colaborador;
import com.hotelaria.projetohotelpesca.services.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/colaboradores")
public class ColaboradorController {

    @Autowired
    private ColaboradorService colaboradorService;

    @GetMapping("/cadastro")
    public String exibirFormularioCadastro(Model model) {
        model.addAttribute("colaborador", new Colaborador());
        return "formulario_cadastro_colaborador";
    }

    @PostMapping("/cadastro")
    public String cadastrarColaborador(Colaborador colaborador, Model model) {
        colaboradorService.adicionar(colaborador);
        model.addAttribute("mensagem", "Colaborador cadastrado com sucesso!");
        return "confirmacao_cadastro";
    }
}
