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

import java.util.Random;


public class RollingDie2 {
    private Random random;
    private int sidesCount;

    public RollingDie2() {
        sidesCount = 6;
        random = new Random();
    }

    public RollingDie2(int sidesCount) {
        this.sidesCount = sidesCount;
        random = new Random();
    }

    public int getSidesCount() {
        return sidesCount;
    }

    public int roll() {
        return random.nextInt(sidesCount) + 1;
    }


    public String toString() {
        return String.format("Rolling die with %s sides", sidesCount);
    }

}