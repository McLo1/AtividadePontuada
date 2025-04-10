package com.example.atividadePontuada.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class devController {

    @RequestMapping("/dev")
    public String dev(){
        return "Desenvolvido por Marcelo Marcio";
    }

}
