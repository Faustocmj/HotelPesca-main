package com.hotelaria.projetohotelpesca.controller;

import com.hotelaria.projetohotelpesca.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private UsuarioService userService;

    @GetMapping("/login")
    public String home(){
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("usuario") String usuario,
                        @RequestParam("senha") String senha, Model model) {

        if (userService.authenticate(usuario, senha)) {
            return "index"; // Redireciona para index.html
        } else {
            model.addAttribute("status", "error");
            model.addAttribute("message", "Login incorreto");
            return "login"; // Retorna para a página de login com a mensagem de erro
        }
    }
}
