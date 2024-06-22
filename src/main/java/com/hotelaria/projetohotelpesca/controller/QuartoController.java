package com.hotelaria.projetohotelpesca.controller;

import com.hotelaria.projetohotelpesca.entities.Quarto;
import com.hotelaria.projetohotelpesca.enums.CategoriaQuarto;
import com.hotelaria.projetohotelpesca.services.QuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/quartos")
public class QuartoController {

    @Autowired
    private QuartoService quartoService;

    @GetMapping
    public String buscarTodos(Model model) {
        List<Quarto> quartos = quartoService.buscarTodos();
        model.addAttribute("quartos", quartos);
        return "quartos";
    }

    @GetMapping("/new")
    public String showNewQuartoForm(Model model) {
        model.addAttribute("quarto", new Quarto());
        model.addAttribute("categorias", CategoriaQuarto.values());
        return "new_quarto";
    }

    @PostMapping
    public String createQuarto(@ModelAttribute Quarto quarto) {
        quartoService.saveQuarto(quarto);
        return "redirect:/quartos";
    }

    @GetMapping("/edit/{id}")
    public String showEditQuartoForm(@PathVariable Integer id, Model model) {
        Quarto quarto = quartoService.buscarPorCod(id);
        model.addAttribute("quarto", quarto);
        model.addAttribute("categorias", CategoriaQuarto.values());
        return "edit_quarto";
    }

    @PostMapping("/edit/{id}")
    public String updateQuarto(@PathVariable Integer id, @ModelAttribute Quarto quarto) {
        quarto.setNumQuarto(id);
        quartoService.saveQuarto(quarto);
        return "redirect:/quartos";
    }

    @GetMapping("/delete/{id}")
    public String deleteQuarto(@PathVariable Integer id) {
        quartoService.deleteQuarto(id);
        return "redirect:/quartos";
    }
}
