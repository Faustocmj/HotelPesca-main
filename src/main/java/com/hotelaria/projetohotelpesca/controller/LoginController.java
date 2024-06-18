package com.hotelaria.projetohotelpesca.controller;

import com.hotelaria.projetohotelpesca.entities.Usuario;
import com.hotelaria.projetohotelpesca.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> credentials) {
        String usuario = credentials.get("usuario");
        String senha = credentials.get("senha");

        if (userService.authenticate(usuario, senha)) {
            return ResponseEntity.ok(Map.of("status", "success", "message", "Login efetuado com sucesso"));
        } else {
            return ResponseEntity.badRequest().body(Map.of("status", "error", "message", "Login incorreto"));
        }
    }

    @PostMapping("/register")
    public Map<String, String> register(@RequestBody Usuario usuario) {
        Map<String, String> response = new HashMap<>();
        try {
            Usuario newUser = userService.registerUser(usuario);
            response.put("status", "success");
            response.put("message", "Registro efetuado com sucesso");
            response.put("userId", newUser.getCodUsuario().toString());
        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", "Erro ao registrar usuário: " + e.getMessage());
        }
        return response;
    }
}
