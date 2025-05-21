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

public class ArenaFight2
{
    public static void main(String[] args) {


        // creating objects
        RollingDie2 die = new RollingDie2(10);
        Warrior zalgoren = new Warrior("Zalgoren", 100, 20, 10, die);
        Warrior gandalf = new Mage("Gandalf", 60, 15, 12, die, 30, 45);
        Arena arena = new Arena(zalgoren, gandalf, die);
        // fight
        arena.fight();



    }
}
