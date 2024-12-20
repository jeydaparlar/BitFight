package bitFight;

import java.time.Duration;
import java.time.LocalDateTime;

public enum Attack implements Action {
    PUNCH(10, "punch", ActionHeight.HIGH, 10),
    KICK(20, "kick", ActionHeight.LOW, 20),
    SUPERMANPUNCH(50,"supermanpunch", ActionHeight.HIGH, 20),
    DOUBLEKICK(60, "doublekick", ActionHeight.LOW, 20);

    private int damage;
    private String name;
    private ActionHeight height;
    private int energyCost;
    
    Attack(int damage, String name, ActionHeight height, int energyCost) {
        this.damage = damage;
        this.name = name;
        this.height = height;
        this.energyCost = energyCost;
    }
    public int getDamage() {
        return damage;
    }

    public String getAction() {
        return "Attack";
    }
    public String getName() {
        return name;
    }

    public ActionHeight getHeight(){
        return height;
    }

    public double getEnergyCost(){
        return energyCost;
    }

    public static boolean attackInTime(LocalDateTime timeBeforeAttack, int attackTime) {
        System.out.println(timeBeforeAttack);
        System.out.println(LocalDateTime.now());
        System.out.println(Duration.between(timeBeforeAttack, LocalDateTime.now()).toSeconds());
        return (Duration.between(timeBeforeAttack, LocalDateTime.now()).toSeconds() > attackTime);
    }

    public ActionType getActionType(){
        return ActionType.ATTACK;
    }
}