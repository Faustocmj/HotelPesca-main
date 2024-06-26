package com.hotelaria.projetohotelpesca.controller;

import com.hotelaria.projetohotelpesca.entities.Cliente;
import com.hotelaria.projetohotelpesca.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/cadastro")
    public String exibirFormularioCadastro(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "formulario_cadastro_cliente";
    }

    @PostMapping("/cadastro")
    public String cadastrarCliente(Cliente cliente, Model model) {
        clienteService.adicionar(cliente);
        model.addAttribute("mensagem", "Cliente cadastrado com sucesso!");
        return "confirmacao_cadastro";
    }
}
