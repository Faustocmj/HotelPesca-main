package com.hotelaria.projetohotelpesca.controller;

import com.hotelaria.projetohotelpesca.entities.Cliente;
import com.hotelaria.projetohotelpesca.entities.Colaborador;
import com.hotelaria.projetohotelpesca.entities.Quarto;
import com.hotelaria.projetohotelpesca.entities.Solicitacao;
import com.hotelaria.projetohotelpesca.enums.CategoriaQuarto;
import com.hotelaria.projetohotelpesca.enums.Disponibilidade;
import com.hotelaria.projetohotelpesca.enums.Status;
import com.hotelaria.projetohotelpesca.services.ClienteService;
import com.hotelaria.projetohotelpesca.services.QuartoService;
import com.hotelaria.projetohotelpesca.services.SolicitacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
    public String saveQuarto(@ModelAttribute Quarto quarto) {
        quarto.setDisponibilidade(Disponibilidade.DISPONIVEL); // Definindo a disponibilidade como DISPONIVEL por padrão
        quartoService.saveQuarto(quarto);
        return "redirect:/quartos";
    }

    @GetMapping("/edit/{id}")
    public String showEditQuartoForm(@PathVariable Integer id, Model model) {
        Quarto quarto = quartoService.buscarPorCod(id);
        model.addAttribute("quarto", quarto);
        model.addAttribute("categorias", CategoriaQuarto.values());
        model.addAttribute("disponibilidades", Disponibilidade.values());
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

    @GetMapping("/quartos-disponiveis")
    public String listarQuartosDisponiveis(Model model, @RequestParam Integer clienteId) {
        List<Quarto> quartosDisponiveis = quartoService.buscarPorDisponibilidade(Disponibilidade.DISPONIVEL);
        model.addAttribute("quartosDisponiveis", quartosDisponiveis);
        model.addAttribute("clienteId", clienteId);
        return "listar_quartos_disponiveis";
    }


    // @PostMapping("/solicitacoes/reservar/{numQuarto}")
    // public String reservarQuarto(@PathVariable Integer numQuarto, @RequestParam("clienteId") Integer clienteId) {
    //     Cliente cliente = clienteService.buscarPorCod(clienteId);
    //     if (cliente != null) {
    //         Solicitacao solicitacao = new Solicitacao();
    //         solicitacao.setCliente(cliente);
    //         solicitacao.setColaborador(null);  // Deixe o colaborador como nulo
    //         solicitacao.setStatus(Status.ABERTO);

    //         solicitacaoService.save(solicitacao); 

    //         // Atualize a disponibilidade do quarto para INDISPONIVEL
    //         Quarto quarto = quartoService.buscarPorCod(numQuarto);
    //         if (quarto != null) {
    //             quarto.setDisponibilidade(Disponibilidade.INDISPONIVEL);
    //             quartoService.saveQuarto(quarto);
    //         }
    //     }
    //     return "redirect:/quartosDisponiveis";
    // }
}
