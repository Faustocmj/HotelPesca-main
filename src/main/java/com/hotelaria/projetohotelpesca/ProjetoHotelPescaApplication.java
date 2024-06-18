package com.hotelaria.projetohotelpesca;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.hotelaria.projetohotelpesca")
public class ProjetoHotelPescaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoHotelPescaApplication.class, args);
	}

}
