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


import java.util.Scanner;

public class HlavnaTrieda {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SpravaPoistenych sprava = new SpravaPoistenych();

        while (true) { //úvodná navigácia
            System.out.println("\nEvidencia poistených:");
            System.out.println("1. Pridať poistného");
            System.out.println("2. Zobraziť zoznam všetkých poistených");
            System.out.println("3. Vyhľadanie poistného");
            System.out.println("4. Skončiť program");
            System.out.println("Vybrať možnosť:");
            String volba = scanner.nextLine();

            switch (volba) { //výber možností
                case "1":
                    pridajPoisteneho(sprava);
                    break;
                case "2":
                    sprava.zobrazPoistenych();
                    break;
                case "3":
                    najdiPoisteneho(sprava);
                    break;
                case "4":
                    System.out.println("Program sa ukončuje.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Neplatná voľba, skúste znova.");
                    break;
            }
        }
        
    }
    private static void pridajPoisteneho(SpravaPoistenych sprava)
    { //pridanie nového poisteného: meno, priezvisko, vek, telefonné číslo
        System.out.println("Zadajte meno poisteného: ");
        String meno = scanner.nextLine();
        System.out.println("Zadajte priezvisko poisteného: ");
        String priezvisko = scanner.nextLine();
        System.out.println("Zadajte vek poisteného: ");
        int vek = Integer.parseInt(scanner.nextLine());
        System.out.println("Zadajte telefónne číslo poisteného: ");
        String telefon = scanner.nextLine();

        sprava.pridajPoisteneho(meno, priezvisko, vek, telefon);
    }

    private static void najdiPoisteneho (SpravaPoistenych sprava)
    { //vyhľadanie poistených podľa mena a priezviska
        System.out.println("Zadajte meno poisteného: ");
        String meno = scanner.nextLine();
        System.out.println("Zadajte priezvisko poisteného: ");
        String priezvisko = scanner.nextLine();

        sprava.najdiPoisteneho(meno, priezvisko);

    }
}
