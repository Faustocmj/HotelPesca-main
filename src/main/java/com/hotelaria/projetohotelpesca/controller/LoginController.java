package com.hotelaria.projetohotelpesca.controller;

import com.hotelaria.projetohotelpesca.entities.Cliente;
import com.hotelaria.projetohotelpesca.entities.Colaborador;
import com.hotelaria.projetohotelpesca.services.ClienteService;
import com.hotelaria.projetohotelpesca.services.ColaboradorService;
import com.hotelaria.projetohotelpesca.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ColaboradorService colaboradorService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/loginCliente")
    public String loginCliente() {
        return "loginCliente";
    }

    @PostMapping("/loginCliente")
    public String loginCliente(@RequestParam("usuario") String usuario, @RequestParam("senha") String senha, Model model) {
        if (usuarioService.authenticate(usuario, senha)) {
            Cliente cliente = clienteService.buscarPorCod(usuarioService.findByUsuario(usuario).getCodUsuario().intValue());
            if (cliente != null) {
                model.addAttribute("cliente", cliente);
                return "listar_quartos_disponiveis";
            }
        }
        model.addAttribute("error", "Usuário ou senha inválidos");
        return "loginCliente";
    }

    @GetMapping("/loginColaborador")
    public String loginColaborador() {
        return "loginColaborador";
    }

    @PostMapping("/loginColaborador")
    public String loginColaborador(@RequestParam("usuario") String usuario, @RequestParam("senha") String senha, Model model) {
        if (usuarioService.authenticate(usuario, senha)) {
            Colaborador colaborador = colaboradorService.buscarPorCod(usuarioService.findByUsuario(usuario).getCodUsuario().intValue());
            if (colaborador != null) {
                model.addAttribute("colaborador", colaborador);
                return "redirect:/solicitacoes";
            }
        }
        model.addAttribute("error", "Usuário ou senha inválidos");
        return "loginColaborador";
    }
}
