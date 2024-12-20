package bitFight;

public class Player extends Character{

    public Player (String name){
        super();
        super.name = name;
    }

    public String toString() {
        return name + " : level " + level + " - Current life level : " + currentHealth;
    }
}
