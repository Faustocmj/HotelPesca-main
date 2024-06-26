package com.hotelaria.projetohotelpesca.controller;

import com.hotelaria.projetohotelpesca.DTO.SolicitacaoDTO;
import com.hotelaria.projetohotelpesca.entities.Cliente;
import com.hotelaria.projetohotelpesca.entities.Colaborador;
import com.hotelaria.projetohotelpesca.entities.Quarto;
import com.hotelaria.projetohotelpesca.entities.Solicitacao;
import com.hotelaria.projetohotelpesca.services.SolicitacaoService;
import com.hotelaria.projetohotelpesca.services.QuartoService;
import com.hotelaria.projetohotelpesca.services.ClienteService;
import com.hotelaria.projetohotelpesca.services.ColaboradorService;
import com.hotelaria.projetohotelpesca.enums.Disponibilidade;
import com.hotelaria.projetohotelpesca.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/solicitacoes")
public class SolicitacaoController {

    @Autowired
    private SolicitacaoService solicitacaoService;

    @Autowired
    private QuartoService quartoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ColaboradorService colaboradorService;

    @GetMapping
    public String listarSolicitacoes(Model model) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        List<Solicitacao> solicitacoes = solicitacaoService.listarTodas();
        List<SolicitacaoDTO> solicitacaoDTOs = solicitacoes.stream()
                .map(s -> new SolicitacaoDTO(s.getCodSolicitacao(),
                        s.getCliente().getNome(), // Aqui estamos acessando o cliente diretamente
                        s.getColaborador().getNome(), // Aqui estamos acessando o colaborador diretamente
                        s.getDataCriacao().format(formatter),
                        s.getStatus().toString()))
                .collect(Collectors.toList());
        model.addAttribute("solicitacoes", solicitacaoDTOs);
        return "listar_solicitacoes";
 

    // @PostMapping("/reservar/{numQuarto}")
    // public String reservarQuarto(@PathVariable Integer numQuarto, @RequestParam Integer clienteId, @RequestParam Integer colaboradorId) {
    //     try {
    //         Quarto quarto = quartoService.buscarPorCod(numQuarto);
    //         if (quarto.getDisponibilidade() == Disponibilidade.DISPONIVEL) {
    //             quarto.setDisponibilidade(Disponibilidade.INDISPONIVEL);
    //             quartoService.saveQuarto(quarto);

    //             Cliente cliente = clienteService.buscarPorCod(clienteId);
    //             Colaborador colaborador = colaboradorService.buscarPorCod(colaboradorId);
    //             Solicitacao solicitacao = new Solicitacao();
    //             solicitacao.setCliente(cliente);
    //             solicitacao.setColaborador(colaborador);
    //             solicitacao.setStatus(Status.ABERTO);
    //             solicitacaoService.save(solicitacao);
    //         }
    //     } catch (Exception e) {
    //         // Trate a exceção conforme necessário
    //         e.printStackTrace();
    //     }
    //     return "redirect:/solicitacoes";
    }
}
