package com.example.atividadePontuada.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestController
public class WelcomeController { //Endpoint Welcome para tela inicial da API

    @RequestMapping("/")
    public String Welcome(){
        return "Seja bem vindo";
    }

}
