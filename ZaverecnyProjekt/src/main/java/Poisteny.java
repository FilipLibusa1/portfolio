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

public class Poisteny {
    private String meno;
    private String priezvisko;
    private int vek;
    private String telefon;

    public Poisteny(String meno, String priezvisko, int vek, String telefon)
    {
        if (meno.trim().isEmpty()|| priezvisko.trim().isEmpty()){
            throw new IllegalArgumentException("Meno a priezvisko nesmu byť prázdne.");
        }
        this.meno = meno;
        this.priezvisko = priezvisko;
        this.vek = vek;
        this.telefon = telefon;
    }

    public String getMeno() {
        return meno;
    }

    public String getPriezvisko() {
        return priezvisko;
    }
    public String toString() //výpis poistených
    {
        return "Meno: " + meno + ", Priezvisko: " + priezvisko + ", Vek: " + vek + ", Telefón: " + telefon;
    }
}
