package com.hotelaria.projetohotelpesca;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.hotelaria.projetohotelpesca.entities.Usuario;

import jakarta.persistence.EntityManager;

@SpringBootApplication
public class ProjetoHotelPescaApplication implements CommandLineRunner {

    @Autowired
    private EntityManager entityManager;

    public static void main(String[] args) {
        SpringApplication.run(ProjetoHotelPescaApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        System.out.println("=== TESTE 2: INCLUIR NOVO USUÁRIO");
        Usuario userTeste = new Usuario(null, "UserTeste2", "teste2", "teste2", "teste2", "teste2", "teste2", "teste2", "teste2", LocalDate.of(2001, 2, 7));

        entityManager.persist(userTeste);

        System.out.println("Pronto");
    }
}
