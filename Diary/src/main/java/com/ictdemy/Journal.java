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

public class Journal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Diary diary = new Diary();
        String choice = "";

        while (!choice.equals("4")) {
            diary.printHomeScreen();
            System.out.println();
            System.out.println("Choose an action:");
            System.out.println("1 - Add an entry");
            System.out.println("2 - Search for entries");
            System.out.println("3 - Delete entries");
            System.out.println("4 - End");
            choice = scanner.nextLine();
            System.out.println();

            switch (choice) {
                case "1":
                    diary.addEntry();
                    break;
                case "2":
                    diary.searchEntries();
                    break;
                case "3":
                    diary.deleteEntries();
                    break;
                case "4":

                    break;
                default:
                    System.out.println("Error. Try again.");
                    break;
            }
        }
    }
}