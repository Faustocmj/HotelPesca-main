package com.hotelaria.projetohotelpesca.controller;

import com.hotelaria.projetohotelpesca.entities.Usuario;
import com.hotelaria.projetohotelpesca.services.UsuarioService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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


    @PostMapping("/register")
    public String register(@ModelAttribute Usuario usuario, Model model) {
        try {
            Usuario newUser = userService.save(usuario);
            model.addAttribute("status", "success");
            model.addAttribute("message", "Registro efetuado com sucesso");
            model.addAttribute("userId", newUser.getCodUsuario().toString());
            return "redirect:/"; // Redirecionar para uma página de sucesso ou outro endpoint
        } catch (Exception e) {
            model.addAttribute("status", "error");
            model.addAttribute("message", "Erro ao registrar usuário: " + e.getMessage());
            return "register"; // Voltar à página de registro com a mensagem de erro
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

    @PostMapping("/usuarios/{id}/editar") // Mudança aqui para POST
    public String atualizarUsuario(@PathVariable Long id, @ModelAttribute Usuario usuario, RedirectAttributes redirectAttributes) {
        try {
            Usuario existingUser = userService.findById(id);
            if (existingUser != null) {
                usuario.setCodUsuario(id); // Garantindo que o ID seja o mesmo do usuário existente
                userService.save(usuario); // Salva as atualizações
                redirectAttributes.addFlashAttribute("successMessage", "Usuário atualizado com sucesso");
            } else {
                redirectAttributes.addFlashAttribute("errorMessage", "Usuário não encontrado com o ID: " + id);
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Erro ao atualizar usuário: " + e.getMessage());
        }
        return "redirect:/api/usuarios"; // Redireciona para a página de edição do usuário
    }

    @GetMapping("/usuarios/pesquisar")
    public String pesquisarUsuarios(@RequestParam("keyword") String keyword, Model model) {
        List<Usuario> usuarios = userService.pesquisarUsuarios(keyword);
        model.addAttribute("usuarios", usuarios);
        return "painel"; // Substitua pelo nome da sua página de lista de usuários
    }
}
