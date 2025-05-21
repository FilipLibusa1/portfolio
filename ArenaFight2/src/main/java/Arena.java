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

public class Arena {
    private Warrior warrior1;
    private Warrior warrior2;
    private RollingDie2 die;

    public Arena(Warrior warrior1, Warrior warrior2, RollingDie2 die) {
        this.warrior1 = warrior1;
        this.warrior2 = warrior2;
        this.die = die;
    }

    private void render() {
        System.out.println("-------------- Arena -------------- \n");
        System.out.println("Warriors: \n");
        printWarrior(warrior1);
        System.out.println();
        printWarrior(warrior2);
        System.out.println();
    }

    private void printMessage(String message) {
        System.out.println(message);
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            System.err.println("Unable to put the thread to sleep");
        }
    }

    private void printWarrior(Warrior warrior) {
        System.out.println(warrior);
        System.out.print("Health: ");
        System.out.println(warrior.healthBar());
        if (warrior instanceof Mage) {
            System.out.print("Mana: ");
            System.out.println(((Mage)warrior).manaBar());
        }
    }

    public void fight() {
        // The original order
        Warrior warrior1 = this.warrior1;
        Warrior warrior2 = this.warrior2;
        System.out.println("Welcome to the Arena!");
        System.out.printf("Today %s will battle against %s! %n", warrior1, warrior2);
        // swapping the warriors
        boolean warrior2Starts = (die.roll() <= die.getSidesCount() / 2);
        if (warrior2Starts) {
            warrior1 = this.warrior2;
            warrior2 = this.warrior1;
        }
        System.out.printf("%s goes first!%nLet the battle begin...%n", warrior1);

        // fight loop
        while (warrior1.isAlive() && warrior2.isAlive()) {
            warrior1.attack(warrior2);
            render();
            printMessage(warrior1.getLastMessage()); // attack message
            printMessage(warrior2.getLastMessage()); // defense message
            if (warrior2.isAlive()) {
                warrior2.attack(warrior1);
                render();
                printMessage(warrior2.getLastMessage()); // attack message
                printMessage(warrior1.getLastMessage()); // defense message
            }
            System.out.println();
        }
    }
}

