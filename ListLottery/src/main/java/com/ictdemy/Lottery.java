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

package com.ictdemy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;



public class Lottery {


    private ArrayList<Integer> numbers;


    private Random random;


    public Lottery() {
        random = new Random();
        numbers = new ArrayList<Integer>();
    }



    public int lot() {
        Integer number = random.nextInt(100) + 1;
        numbers.add(number);
        return number;
    }



    public String print() {
        String output = "";
        Collections.sort(numbers);
        for (int number : numbers) {
            output += number + " ";
        }
        return output;
    }

}