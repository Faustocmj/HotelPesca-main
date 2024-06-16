package com.hotelaria.projetohotelpesca.repositories;

import com.hotelaria.projetohotelpesca.entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

    @Query("SELECT r " +
            "FROM Reserva r " +
            "JOIN r.quartos q " +
            "WHERE q.numQuarto = :numQuarto " +
            "AND r.checkIn < :checkOut " +
            "AND r.checkOut > :checkIn")
    List<Reserva> findReservasConflitantes(@Param("numQuarto") Integer numQuarto,
                                           @Param("checkIn") LocalDateTime checkIn,
                                           @Param("checkOut") LocalDateTime checkOut);
}
