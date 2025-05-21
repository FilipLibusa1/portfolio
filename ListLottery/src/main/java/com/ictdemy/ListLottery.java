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

import java.util.Scanner;



public class ListLottery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lottery lottery = new Lottery();
        System.out.println("Welcome to our lottery program.");
        String choice = "0";
// main loop
        while (!choice.equals("3")) {
            // option list
            System.out.println("1 - Lot the next number");
            System.out.println("2 - Print numbers");
            System.out.println("3 - Quit");
            choice = scanner.nextLine();
            System.out.println();
            // reaction to choice
            switch (choice) {
                case "1":
                    System.out.printf("You got a: %s%n", lottery.lot());
                    break;
                case "2":
                    System.out.printf("Numbers drawn: %s%n", lottery.print());
                    break;
                case "3":
                    System.out.println("Thanks for using our Lotto program");
                    break;
                default:
                    System.out.println("Invalid option. Please, try again.");
                    break;
            }
        }
}
}