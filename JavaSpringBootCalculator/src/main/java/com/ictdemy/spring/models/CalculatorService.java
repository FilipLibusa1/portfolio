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

package com.ictdemy.spring.models;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public float calculate(CalculatorDTO calculator) {
        if (calculator.getOperation().equals("+")) {
            return calculator.getNumber1() + calculator.getNumber2();
        } else if (calculator.getOperation().equals("-")) {
            return calculator.getNumber1() - calculator.getNumber2();
        } else if (calculator.getOperation().equals("*")) {
            return calculator.getNumber1() * calculator.getNumber2();
        } else { // Poslední možnost může být pouze dělení
            if (calculator.getNumber2() == 0) {
                throw new IllegalArgumentException("Second number cannot be 0!");
            }
            return calculator.getNumber1() / calculator.getNumber2();
        }
    }

}
