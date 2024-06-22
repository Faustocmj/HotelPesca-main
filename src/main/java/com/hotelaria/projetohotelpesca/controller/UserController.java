package com.hotelaria.projetohotelpesca.controller;

import com.hotelaria.projetohotelpesca.entities.Usuario;
import com.hotelaria.projetohotelpesca.exceptions.ResourceNotFoundException;
import com.hotelaria.projetohotelpesca.services.UsuarioService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/api")
public class UserController {

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
            return "redirect:/api/usuarios";
        } else {
            model.addAttribute("status", "error");
            model.addAttribute("message", "Login incorreto");
            return "login"; // Retorna para a página de login com a mensagem de erro
        }
    }

    @GetMapping("/register")
    public String registra() {
        return "register";
    }


    @PostMapping(value = "/register", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public String register(@ModelAttribute Usuario usuario, Model model) {
        try {
            Usuario newUser = userService.save(usuario);
            if (newUser == null) {
                model.addAttribute("status", "error");
                model.addAttribute("message", "Usuário já existe.");
                return "register";
            }
            model.addAttribute("status", "success");
            model.addAttribute("message", "Registro efetuado com sucesso");
            model.addAttribute("userId", newUser.getCodUsuario().toString());
            return "redirect:/";
        } catch (Exception e) {
            model.addAttribute("status", "error");
            model.addAttribute("message", "Erro ao registrar usuário: " + e.getMessage());
            return "register";
        }
    }

    @GetMapping("/usuarios")
    public String listarUsuarios(Model model) {
        List<Usuario> usuarios = userService.findAll();
        model.addAttribute("usuarios", usuarios);
        return "painel";
    }

    @GetMapping("/usuarios/{id}/delete")
    public String deletarUsuario(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/api/usuarios";
    }

    @GetMapping("/usuarios/{id}/editar")
    public String editarUsuario(@PathVariable Long id, Model model) {
        Usuario usuario = userService.findById(id);
        model.addAttribute("usuario", usuario);
        return "edit-user";
    }

    @PostMapping("/usuarios/{id}/editar")
    public String editarUsuario(@PathVariable Long id, @ModelAttribute Usuario usuario, RedirectAttributes redirectAttributes) {
        try {
            userService.update(id, usuario);
            redirectAttributes.addFlashAttribute("successMessage", "Usuário atualizado com sucesso");
        } catch (ResourceNotFoundException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Erro ao atualizar usuário: " + e.getMessage());
        }
        return "redirect:/api/usuarios";
    }

    @GetMapping("/usuarios/pesquisar")
    public String pesquisarUsuarios(@RequestParam("keyword") String keyword, Model model) {
        List<Usuario> usuarios = userService.pesquisarUsuarios(keyword);
        model.addAttribute("usuarios", usuarios);
        return "painel";
    }
}
