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

import java.util.ArrayList;
import java.util.List;

public class SpravaPoistenych {
    private List<Poisteny> poistenyZoznam;

    public SpravaPoistenych() {
        poistenyZoznam = new ArrayList<>();
    }

    public void pridajPoisteneho(String meno, String priezvisko, int vek, String telefon) {
        try {
            Poisteny novyPoisteny = new Poisteny(meno, priezvisko, vek, telefon);
            poistenyZoznam.add(novyPoisteny);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void zobrazPoistenych() {
        if (poistenyZoznam.isEmpty()) {
            System.out.println("Zoznam poistených je prázdny.");
        } else {
            for (Poisteny poisteny : poistenyZoznam) {
                System.out.println(poisteny);
            }
        }
    }
    public void najdiPoisteneho(String meno, String priezvisko)
    {
        for (Poisteny poisteny : poistenyZoznam)
        {
            if (poisteny.getMeno().equals(meno) && poisteny.getPriezvisko().equals(priezvisko))
            {
                System.out.println(poisteny);
                return;
            }
        }
        System.out.println("Poistený s daným menom a priezviskom sa nenachádza v zozname");
    }
}