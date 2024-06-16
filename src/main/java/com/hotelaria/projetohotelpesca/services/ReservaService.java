package com.hotelaria.projetohotelpesca.services;

import com.hotelaria.projetohotelpesca.entities.Quarto;
import com.hotelaria.projetohotelpesca.entities.Reserva;
import com.hotelaria.projetohotelpesca.entities.Solicitacao;
import com.hotelaria.projetohotelpesca.repositories.QuartoRepository;
import com.hotelaria.projetohotelpesca.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private QuartoRepository quartoRepository;

    public Reserva criarReserva(Solicitacao solicitacao, List<Integer> numerosQuartos,
                                LocalDateTime checkIn, LocalDateTime checkOut,
                                Integer qtdDiasPesca) {

        // Verificar a disponibilidade dos quartos
        for(Integer numQuarto : numerosQuartos) {
            List<Reserva> reservasConflitantes = reservaRepository.findReservasConflitantes(numQuarto, checkIn,
                    checkOut);
            if(!reservasConflitantes.isEmpty()) {
                throw new RuntimeException("Quarto " + numQuarto + " não está disponível para as datas solicitadas.");
            }
        }

        Reserva reserva = new Reserva(solicitacao, checkIn, checkOut, qtdDiasPesca);

        for(Integer numQuarto : numerosQuartos) {
            Quarto quarto = quartoRepository.findById(numQuarto).orElseThrow(() -> new RuntimeException("Quarto não encontrado."));
            reserva.getQuartos().add(quarto);
        }

        return reservaRepository.save(reserva);
    }

    public List<Reserva> buscarTodos() {
        return reservaRepository.findAll();
    }

    public Reserva buscarPorCod(Integer Cod) {
        Optional<Reserva> obj = reservaRepository.findById(Cod);
        return obj.get();
    }
}
