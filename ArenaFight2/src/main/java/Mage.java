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

public class Mage extends Warrior {
    private int mana;
    private int maxMana;
    private int magicDamage;

    public Mage(String name, int health, int damage, int defense, RollingDie2 die, int mana, int magicDamage) {
        super(name, health, damage, defense, die);
        this.mana = mana;
        this.maxMana = mana;
        this.magicDamage = magicDamage;
    }
    @Override
    public void attack(Warrior enemy) {
        int hit = 0;
        // Mana isn't full
        if (mana < maxMana) {
            mana += 10;
            if (mana > maxMana) {
                mana = maxMana;
            }
            hit = damage + die.roll();
            setMessage(String.format("%s attacks with a hit worth %s hp", name, hit));
        } else { // Magic damage
            hit = magicDamage + die.roll();
            setMessage(String.format("%s used magic worth %s hp", name, hit));
            mana = 0;
        }
        enemy.defend(hit);
    }
    public String manaBar() {
        return graphicalBar(mana, maxMana);
    }

}