package com.hotelaria.projetohotelpesca.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @PostMapping("/api/login")
    public Map<String, String> login(@RequestBody Map<String, String> credentials) {
        String login = credentials.get("login");
        String password = credentials.get("password");

        Map<String, String> response = new HashMap<>();
        if ("user".equals(login) && "password".equals(password)) {
            response.put("status", "success");
            response.put("message", "Login efetuado com sucesso");
        } else {
            response.put("status", "error");
            response.put("message", "Login incorreto");
        }
        return response;
    }
}
