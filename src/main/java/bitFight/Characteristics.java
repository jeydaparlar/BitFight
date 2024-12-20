package bitFight;

import java.util.Random;

public enum Characteristics {
    DUR (1.2, 1, 1, "Dur"),
    BRAVE (1, 1.2, 1, "Brave"),
    VIF (1, 1, 1.2, "Vif"),
    RÉSILIENT (1.2, 0.8, 1.2, "Résilient"),
    PUISSANT (1, 1.3, 0.8, "Puissant"),
    NORMAL (1, 1, 1, "Normal");

    private double healthBoost;
    private double attackBoost;
    private double energyBoost;
    private String name;

    private Characteristics(double healthBoost, double attackBoost, double energyBoost, String name) {
        this.healthBoost = healthBoost;
        this.attackBoost = attackBoost;
        this.energyBoost = energyBoost;
        this.name = name;
    }

    public double getHealthBoost() {
        return healthBoost;
    }

    public double getAttackBoost() {
        return attackBoost;
    }

    public double getEnergyBoost() {
        return energyBoost;
    }

    public String getName() {
        return name;
    }

    public static Characteristics randomCharacteristic(){
        Random rand = new Random();
        return Characteristics.values()[(int) rand.nextDouble() * Characteristics.values().length];
    }
}
