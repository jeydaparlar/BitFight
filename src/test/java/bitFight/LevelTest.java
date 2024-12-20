package bitFight;

import java.io.IOException;

public class LevelTest {
     public static void main(String[] args) throws IOException, InterruptedException {
          Enemy enemy = new Enemy("BAD PAUL", 1); 
          Player player = new Player("play");    
          Level level = new Level(1, player, enemy);
          level.fightScene();
          level.bigFightScene();
          Thread.sleep(1250);
          Display.clearScreen();
          level.displayLifePoints();
          Thread.sleep(1250);
          Display.clearScreen();
          level.gameOver();
          level.defeat();
          Thread.sleep(1250);
          Display.clearScreen();
          level.victory();
     }
}
