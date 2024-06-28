package com.hotelaria.projetohotelpesca.controller;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

// import com.hotelaria.projetohotelpesca.services.UsuarioService;


@Controller
@RequestMapping
public class IndexController {

    // @Autowired
    // private UsuarioService userService;

    @GetMapping("/rooms-and-suites")
    public String rooms(){
        return "rooms-and-suites";
    }

    @GetMapping("/facilities")
    public String facilities(){
        return "facilities";
    }

    @GetMapping("/contact-page")
    public String contact(){
        return "contact-page";
    }
}