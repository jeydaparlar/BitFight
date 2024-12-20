package bitFight;

import java.io.Serializable;

public class Character implements Serializable {
    protected String name;
    protected double maxHealth;
    protected double currentHealth;
    protected double attackMultiplier;
    protected double maxEnergy;
    protected double currentEnergy;
    protected int level;

    public Character(double maxHealth, double currentHealth, double attackMultiplier, double maxEnergy, double currentEnergy, int level) {
        this.maxHealth = maxHealth;
        this.currentHealth = currentHealth;
        this.attackMultiplier = attackMultiplier;
        this.maxEnergy = maxEnergy;
        this.currentEnergy = currentEnergy;
        this.level = level;
    }
    
    public Character(){
        this(100, 100,1, 100, 100,1);
    }
    public Character(int level) {
        this();
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public double getMaxHealth() {
        return maxHealth;
    }
    public void setMaxHealth(double maxHealth) {
        this.maxHealth = maxHealth;
    }
    public double getCurrentHealth() {
        return currentHealth;
    }
    public void setCurrentHealth(double currentHealth) {
        this.currentHealth = currentHealth;
    }
    public double getAttackMultiplier() {
        return attackMultiplier;
    }
    public void setAttackMultiplier(double attackMultiplier) {
        this.attackMultiplier = attackMultiplier;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isDead(){
        return (int) this.currentHealth <= 0;
    }

    public void revive(){
        this.currentHealth = maxHealth;
        this.currentEnergy = maxEnergy;
    }

    public void levelUp() {
        level++;
        maxHealth = maxHealth * 1.2;
        currentHealth = maxHealth;
        attackMultiplier = attackMultiplier * 1.2; 
    }

    public double getMaxEnergy() {
        return maxEnergy;
    }

    public double getCurrentEnergy() {
        return currentEnergy;
    }

    public void damage(double damage){
        this.currentHealth -= damage;
        if(this.currentHealth < 0) this.currentHealth = 0;
    }

    public void exhaust(double exhaustion){
        this.currentEnergy -= exhaustion;
        if(this.currentEnergy < 0) this.currentEnergy = 0;
    } //Fonction qui réduit l'énergie

    public boolean isExhausted(){
        return this.currentEnergy <= 0;
    }



    
} 
