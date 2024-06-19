package com.hotelaria.projetohotelpesca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.hotelaria.projetohotelpesca.entities.Usuario;
import com.hotelaria.projetohotelpesca.services.UsuarioService;

@Controller
@RequestMapping("/api")
public class RegisterController {

    @Autowired
    private UsuarioService userService;

    @GetMapping("/register")
    public String registra() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute Usuario usuario, Model model) {
        try {
            Usuario newUser = userService.save(usuario);
            model.addAttribute("status", "success");
            model.addAttribute("message", "Registro efetuado com sucesso");
            model.addAttribute("userId", newUser.getCodUsuario().toString());
            return "index"; // Redirecionar para uma página de sucesso ou outro endpoint
        } catch (Exception e) {
            model.addAttribute("status", "error");
            model.addAttribute("message", "Erro ao registrar usuário: " + e.getMessage());
            return "register"; // Voltar à página de registro com a mensagem de erro
        }
    }
}
