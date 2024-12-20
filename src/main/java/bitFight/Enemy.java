package bitFight;
import java.util.Random;

public class Enemy extends Character{

    private Characteristics characteristic;

    public Enemy(String name, int level) {
        super(level);
        super.name = name;
        maxHealth = maxHealth * Math.pow(1.2, (level-1));
        maxHealth = statVariation(maxHealth);
        attackMultiplier = attackMultiplier * Math.pow(1.2, level);
        attackMultiplier = statVariation(attackMultiplier);
        

        Random r = new Random();
        if(r.nextDouble() < 0.5){
            characteristic = Characteristics.randomCharacteristic();
            maxHealth = maxHealth * characteristic.getHealthBoost();
            attackMultiplier = attackMultiplier * characteristic.getAttackBoost();
            //TODO ENERGIE
        }
        else {characteristic = Characteristics.NORMAL;}
        currentHealth = maxHealth;
    }

    private double statVariation(double stat){
        Random r = new Random();
        return stat + (r.nextDouble() * (stat * 0.2) - (stat * 0.1));
    }

 
    public String toString() {
        return Terminal.RED + name + " LE " + characteristic.name() + Terminal.RESET + " : level " + Terminal.YELLOW + this.level + Terminal.RESET;
    }

    public Characteristics getCharacteristic() {
        return characteristic;
    }
}
