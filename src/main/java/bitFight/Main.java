package bitFight;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Main {

    public static void main(String[] args) throws IOException, InterruptedException{

        Display.clearScreen();

        Enemy enemy = new Enemy("BAD PAUL", 1); 
        Player player = new Player("play");        
        Menu menu= new Menu("name");
        Level level = new Level(1, player, enemy);
        GameData gamedata = Save.loadObject("res/gamedata");

        Display display = new Display(level);

        if (gamedata != null) {
            player = gamedata.getPlayer();
            level = gamedata.getLevelReached();
            enemy = level.getEnnemy();
        }

        menu.display();
        menu.validate();

        Display.clearScreen();
        menu.displayGameRules();
        menu.validate();

        Display.clearScreen();
        Display.setCursorPos(50,0);
        Display.printDialogBox();

        Display.goToDialogBox();

        
        Display.goToUserInput();
        
        ArrayList<Action> actionList = new ArrayList<>();
        for (Attack a : Attack.values()) actionList.add(a);
        for (Defense d : Defense.values()) actionList.add(d);

        // Récupère le nom de chaque action dans une ArrayList
        ArrayList<String> actionNames = new ArrayList<>();
        for (Action a : actionList) actionNames.add(a.getName());
        
        Scanner in= new Scanner(System.in);
        
        Random rand = new Random();
        
        // arrivée de l'ennemi
        level.ennemyShowing();
        
        Input input = new Input();
        Display.goToDialogBox();
        


        while (!input.getInput().equals("q") && (!enemy.isDead() || !player.isDead())) {

            //A garder au début de la boucle, mesure le temps que le joueur à pris d'écrire
            LocalDateTime timeBeforeAttack = LocalDateTime.now();
            int attackTime = 5;//- (int)(5 * rand.nextDouble());

                level.possibleActions();
                input.newInput(in);
                
                // Boucle tant que le joueur n'a pas taper de nom d'une attaque valide ou tape trop tard ou tape q
                while (!actionNames.contains(input.getInput())  && !input.getInput().equals("q") && !player.isDead()) {
                    
                    
                    if (!actionNames.contains(input.getInput())){
                        Display.clearDialogBox();
                        level.invalidActionChoice();                        
                        input.newInput(in);
                    }
                }
                
                //Si le joueur est trop lent, l'ennemi fait une attaque aléatoire
                if(Attack.attackInTime(timeBeforeAttack, attackTime)){
                    Display.clearDialogBox();
                    Attack randomEnemyAttack = Attack.values()[(int) rand.nextDouble()*Attack.values().length];
                    level.ennemyFaster(randomEnemyAttack);
                    Display.displayNewHealthBar();
                    timeBeforeAttack = LocalDateTime.now();
                    input.newInput(in);
                } 
                
                if(!player.isExhausted() && !input.getInput().equals("q") ){
                    ActionType type = null;
                    for(Action a : actionList) if(a.getName().equals(input.getInput())) type = a.getActionType();
                    if(type == ActionType.ATTACK) {
                        Attack attack = Attack.PUNCH;
                        for(Action a : actionList) if(a.getName().equals(input.getInput())) attack = (Attack) a;
                        level.playerHasEnergy(attack);
                    } else
                    if(type == ActionType.DEFENSE) {
                        Defense defense = Defense.HIGHBLOCK;
                        for(Action a : actionList) if(a.getName().equals(input.getInput())) defense = (Defense) a;
                        Attack randomEnemyAttack = Attack.values()[(int) rand.nextDouble()*Attack.values().length];
                        level.defends(player, defense, randomEnemyAttack);
                    }
                    
                } else {} //TODO ajouter display trop fatigué
                
                
                //Display.clearDialogBox();
                
                Display.newPrintln(enemy.toString());
                
                //Display.clearDialogBox();
                if (player.isExhausted()) player.currentHealth = 0;
                if (enemy.isDead()){
                    level.ennemyDying();
                    player.revive();
                    enemy.revive();
                    enemy.levelUp();
                    level.levelGoingUp();
                    level.displayEndOfLevel();
                    Thread.sleep(4000);                    
                } 
                if (player.isDead()){
                    Display.clearScreen();
                    level.gameOver();
                    level.defeat();
                    break;
                }
            }
            
            in.close();
            Save.saveObject("res/gamedata", gamedata);
        }
}
    