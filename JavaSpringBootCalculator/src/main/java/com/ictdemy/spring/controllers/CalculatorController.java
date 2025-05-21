/************************************************/
/*                                              */
/*   ███████╗██╗██╗     ██╗██████╗              */
/*   ██╔════╝██║██║     ██║██╔══██╗             */
/*   █████╗  ██║██║     ██║██████╔╝             */
/*   ██╔══╝  ██║██║     ██║██╔═══╝              */
/*   ██║     ██║███████╗██║██║                  */
/*   ╚═╝     ╚═╝╚══════╝╚═╝╚═╝                  */
/*                                              */
/************************************************/

package com.ictdemy.spring.controllers;

import com.ictdemy.spring.models.CalculatorDTO;
import com.ictdemy.spring.models.CalculatorService;
import com.ictdemy.spring.models.TitleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("calculator")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping
    public String renderCalculator(@ModelAttribute CalculatorDTO calculatorDTO,
                                   @ModelAttribute TitleDTO titleDTO) {
        titleDTO.setTitle("Spring Calculator!");

        return "calculator";
    }

    @PostMapping
    public String calculate(@ModelAttribute CalculatorDTO calculatorDTO, Model model) {
        float calculationResult = calculatorService.calculate(calculatorDTO);
        model.addAttribute("calculationResult", calculationResult);

        return "result";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String handleIllegalArgumentException() {
        return "invalid-form";
    }
}