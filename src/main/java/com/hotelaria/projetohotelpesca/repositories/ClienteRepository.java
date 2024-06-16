package com.hotelaria.projetohotelpesca.repositories;

import com.hotelaria.projetohotelpesca.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
