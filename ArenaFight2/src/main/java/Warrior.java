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


class Warrior {
    protected String name;
    protected int health;
    protected int maxHealth;
    protected int damage;
    protected int defense;
    protected RollingDie2 die;
    private String message;

    public Warrior(String name, int health, int damage, int defense, RollingDie2 die) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.damage = damage;
        this.defense = defense;
        this.die = die;
    }

    public boolean isAlive() {
        return (health > 0);
    }

    protected String graphicalBar(int current, int maximum) {
        String healthBar = "[";
        int total = 20;
        double count = Math.round(((double)current/ maximum) * total);
        if ((count == 0) && (isAlive())) {
            count = 1;
        }
        for (int i = 0; i < count; i++) {
            healthBar += "#";
        }
        for (int i = 0; i < total - count; i++) {
            healthBar += " ";
        }
        healthBar += "]";
        return healthBar;
    }

    public void attack(Warrior enemy) {
        int hit = damage + die.roll();
        setMessage(String.format("%s attacks with a hit worth %s hp", name, hit));
        enemy.defend(hit);
    }

    public void defend(int hit) {
        int injury = hit - (defense + die.roll());
        if (injury > 0) {
            health -= injury;
            message = String.format("%s defended against the attack but still lost %s hp", name, injury);
            if (health <= 0) {
                health = 0;
                message += " and died";
            }

        } else {
            message = String.format("%s blocked the hit", name);
        }
        setMessage(message);
    }

    protected void setMessage(String message) {
        this.message = message;
    }

    public String getLastMessage() {
        return message;
    }

    @Override
    public String toString() {
        return name;
    }
    public String healthBar() {
        return graphicalBar(health, maxHealth);
    }
}
