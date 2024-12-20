package bitFight;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class SaveTest {
    
    Character character =  new Character();
    Player player =  new Player("playerTestSave");
    Enemy enemy =   new Enemy("enemyTestSave", 1);
    Attack attack =  Attack.DOUBLEKICK;

    @BeforeEach
    void testSaveObject() {
        Save.saveObject("res/characterTestSave.ser", character);
        Save.saveObject("res/playerTestSave.ser", player);
        Save.saveObject("res/enemyTestSave.ser", enemy);
        Save.saveObject("res/attackTestSave.ser", attack);
    }

    @Test
    void testLoadObject() {
        Save.loadObject("res/characterTestSave.ser");
        Save.loadObject("res/enemyTestSave.ser");
        Save.loadObject("res/attackTestSave.ser");

    }

    @Test
    void testLoadPlayer() {
        Player playerLoaded = Save.loadObject("res/playerTestSave.ser");
        assertEquals(playerLoaded.getName(), "playerTestSave");

    }

    @Test
    void testLoadAttack() {
        Attack attackLoaded = Save.loadObject("res/attackTestSave.ser");
        assertEquals(attackLoaded.getAction(), "Attack");

    }

}
