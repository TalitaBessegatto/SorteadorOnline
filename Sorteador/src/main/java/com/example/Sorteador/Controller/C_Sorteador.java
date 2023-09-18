package com.example.Sorteador.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class C_Sorteador {

    @GetMapping("/")
    public String pagHome (){
        return "/Sorteador.html";}

}
