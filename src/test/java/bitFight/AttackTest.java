package bitFight;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import bitFight.Attack;
import bitFight.Enemy;
import bitFight.Player;

public class AttackTest {
 
    Player player = new Player("joueur1");
    Enemy ennemy = new Enemy("ennemy", 1);

    @Test
    void testGetDamage() {
        assertEquals(Attack.PUNCH.getDamage(),10); 
    }

    @Test
    void testAttack() {
        ennemy.setCurrentHealth(100.0);
        assertEquals("Joueur : " + (int)player.getCurrentHealth(), "Joueur : 100");
        assertEquals("Ennemi : " + (int)ennemy.getCurrentHealth(), "Ennemi : 100");
        ennemy.damage(Attack.PUNCH.getDamage());
        player.exhaust(Attack.PUNCH.getEnergyCost());
        assertEquals("Joueur : " + (int)player.getCurrentHealth(), "Joueur : 100");
        assertEquals("Ennemi : " + (int)ennemy.getCurrentHealth(), "Ennemi : 90");
        assertEquals("Energie joueur : " + (int)player.getCurrentEnergy(), "Energie joueur : 90");
    }

}
