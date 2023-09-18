package com.example.Sorteador.Controller;

import com.example.Sorteador.Service.S_Sorteador;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class C_Resultado {

    @GetMapping("/Resultado")
    public String pagResultado() {
        return "/Resultado.html";
    }

    @PostMapping("/")
    public String pagResultado(@RequestParam("quantity") int quantity, @RequestParam("begin") int begin, @RequestParam("end") int end, @RequestParam(name = "ordemIncrease", required = false, defaultValue = "false") boolean ordemIncrease, @RequestParam(name = "repetition", required = false, defaultValue = "false") boolean repetition, Model model) {
        model.addAttribute("quantity",quantity);
        model.addAttribute("data",new Date());
        model.addAttribute("beginEnd",begin + " e " + end);

        if (repetition == true) {
            int[] vetorSorteadoNum = S_Sorteador.sortearNumeros(quantity, begin, end);

            if (ordemIncrease == true) {
                vetorSorteadoNum = S_Sorteador.ordemNumber(vetorSorteadoNum);
        }
            model.addAttribute("numeros", vetorSorteadoNum);
            return "/Resultado";
        } else {
            int[] vNumbers = S_Sorteador.sortearSemRepetition(quantity, begin, end);
            if (ordemIncrease == true) {
                vNumbers = S_Sorteador.ordemNumber(vNumbers);
            }
            model.addAttribute("numeros", vNumbers);
            return "/Resultado";
        }
    }
}

