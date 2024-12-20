package bitFight;

import java.io.IOException;
import java.util.Scanner;

public class Level{

    int nbLevel;
    Player player;
    Enemy ennemy;

    public Level(int nbLevel, Player player, Enemy ennemy){
        this.nbLevel=nbLevel;
        this.player = player;
        this.ennemy = ennemy;
    }
    
    // accesseurs 
    public int getNbLevel() {
        return nbLevel;
    }
    public Enemy getEnnemy() {
        return ennemy;
    }
    public Player getPlayer() {
        return player;
    }

    // mutateurs
    public void setNbLevel(int nbLevel) {
        this.nbLevel = nbLevel;
    }
    
    public void setEnnemy(Enemy ennemy) {
        this.ennemy = ennemy;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }

    // sert seulement à laisser l'utilisateur appuyer sur entrée pour passer
    public boolean check() {
        Scanner sc = new Scanner(System.in);
        String c = sc.nextLine();
        if (c == null) {
            sc.close();
            return false;
        }
        sc.close();
        return true;
    }

    // méthodes d'affichage
    // affiche le numéro de niveau
    public void displayLevelInfos() {
        System.out.println("Level " + this.nbLevel);
    }

    // annonce un nouvel ennemi
    public void ennemyShowing() {
        Display.clearDialogBox();
        System.out.println("An ennemy just appeared : " + this.ennemy.toString());
        System.out.println();
        Display.goToUserInput();
    }

    public void ennemyFaster(Attack attack) throws IOException {
        Display.clearDialogBox();
        System.out.println("The ennemy attacks before you can !");
        player.setCurrentHealth(player.getCurrentHealth() - attack.getDamage() * this.ennemy.getAttackMultiplier()); //Récupère une attaque aléatoire dans l'enum
        ennemy.exhaust(attack.getEnergyCost());
        System.out.println(attack.getName() + "!! You receive " + (int) (attack.getDamage() * this.ennemy.getAttackMultiplier()) + " damage!");
        System.out.println(this.player.getName() + "'s life' : " + this.displayPlayerHealth());
        Display.goToUserInput();
    }


    // affiche la jauge de vie 
        
    public void displayLifePoints (){
        System.err.println();
        System.out.println("Player " + this.player.getName());
        System.out.println();
        System.out.print(Terminal.GREEN+" \t current health "+Terminal.RESET);
        double pourcentage = (this.player.getCurrentHealth()/this.player.getMaxHealth())*100;
        for (int indice = 0; indice < pourcentage/2; indice ++){
            if (pourcentage<=50){
                System.out.print(Terminal.RED+"▬");
            }else{
                System.out.print(Terminal.GREEN+ "▬"+Terminal.RESET);
            }
        }
        System.out.print(" ");
        System.err.println( (int) this.player.getCurrentHealth() + "/" + (int) this.player.getMaxHealth() + "                 ");
        System.out.print(Terminal.YELLOW+"\t current energy "+Terminal.RESET);
        for (int indice = 0; indice < (this.player.getCurrentEnergy())/2; indice ++){
            System.out.print(Terminal.YELLOW +"▬"+ Terminal.RESET);
        }
        System.out.print(" ");
        System.err.println(this.player.getCurrentEnergy() + "/" + this.player.getMaxEnergy());


        System.err.println();
        System.out.println("Ennemy " + this.ennemy.getName());
        System.out.println();
        System.out.print(Terminal.RED+" \t current health "+Terminal.RESET);
        double pourcentageEnnemy = (this.ennemy.getCurrentHealth()/this.ennemy.getMaxHealth())*100;
        for (int indice = 0; indice < pourcentageEnnemy/2; indice ++){
            System.out.print(Terminal.RED+ "▬"+Terminal.RESET);
        }
        System.out.print(" ");
        System.err.println( (int) this.ennemy.getCurrentHealth() + "/" + (int) this.ennemy.getMaxHealth() + " Level : " + ennemy.getLevel() + "                 ");
    }


    public String displayPlayerHealth(){
        return (int )this.player.getCurrentHealth() +" / " + (int) this.player.getMaxHealth();
    }


    // annonce la mort de l'ennemi
    public void ennemyDying() {
        System.out.println("The ennemy is dead!");
    }

    // annonce la mort du joueur
    public void playerDying() {
        System.out.println(this.player.getName() + " is dead!");   
    }

// action quand le joueur n'est pas épuisé
    public void playerHasEnergy(Attack attack) {
        this.ennemy.damage(attack.getDamage() * player.getAttackMultiplier());
        player.exhaust(attack.getEnergyCost());
        System.out.println("You're using " + attack.getName() + "! You lose " + (int) attack.getEnergyCost() + " energy points");
    }

    // affiche les règles du jeu
    public void displayGameRules() {
        System.out.println("To fight, type 'a' and press Enter.");
        System.out.println("To exit the game at any moment, type 'q' and press Enter.");
    }

    // plus petit rappel des commandes (reste statique sur l'écran pour le joueur)
    public void commandsReminder() {
        System.out.println("Commands : \n \t a - attack \n\t q - exit");
    }

    // affiche la fin du niveau
    public void displayEndOfLevel() {
        Display.clearDialogBox();
        
        System.out.println('\n');
        System.out.println("                            Congrats!       "+'\n');
        System.out.println("                   you won your first fight! \n \t ");
        System.out.println("        let's see what you can do with your second ennemy...");
        System.out.println("                this time your enemy health is "+ Terminal.GREEN + (int) this.getEnnemy().getCurrentHealth() + Terminal.RESET);
        
        //Display.goToUserInput();
    }

    // méthodes de combats
    // liste des attaques et défenses possibles pour le joueur
    public void possibleActions() throws IOException {
        Display.clearDialogBox();
        System.out.println("Possible " + Terminal.RED + "attacks" + Terminal.RESET +  " are : \n \t punch, kick, doublekick, supermanpunch");
        System.out.println("Possible " + Terminal.BLUE + "defenses" + Terminal.RESET + " are : \n \t lowblock, highblock\"");
        Display.goToUserInput();
    }

    // quand l'utilisateur choisit une action qui n'existe pas
    public void invalidActionChoice() throws IOException {
        Display.clearDialogBox();
        System.out.println("This action is not available.");
        possibleActions();
        Display.goToUserInput();
    }

    // méthodes de paramètrages
    // vérification de victoire du joueur
    public boolean playerWon() {
        return !this.player.isDead() && this.ennemy.isDead();
    }

    // augmenter le niveau
    public void levelGoingUp() {
        if (playerWon()) {
            System.out.println(">>> Levelling up! <<<");
            this.setNbLevel(nbLevel++);
            System.out.println("                            Congrats!       "+'\n');
            System.out.println("      you won your fight! + \n \t let's see what you can do with your next ennemy...   Good luck! \n\t your currrent enemy level is "+this.ennemy.level );
    
        System.out.println(" \n this time your enemy's health is "+ (int) this.ennemy.currentHealth+ "\n ... ");
        }
    }

    public void defends(Character character, Defense defense, Attack attack){
        if(defense.getHeight() == attack.getHeight()){
            character.currentEnergy += 60;
            if(character.currentEnergy > character.maxEnergy) character.currentEnergy = character.maxEnergy;
            System.out.println("The " + attack.getName() + " is blocked! 60 energy is gained");
        } else {
            character.currentEnergy += 30;
            character.currentHealth -= attack.getDamage();
            System.out.println("The block fails! 30 energy is gained, but damage is still done");
        }
    }
   

    //Affichage ascii

    public  void fightScene() throws IOException{
        Image image=new Image("res/fight.ini", 12);
        image.imageGenerator();
    }

    public  void bigFightScene() throws IOException{
        Image image=new Image("res/mouvement.ini", 16);
        image.imageGenerator();
    }

    public  void gameOver() throws IOException, InterruptedException{
        Image image=new Image("res/game", 9);
        image.imageGenerator();
        Thread.sleep(700);
        Image image2=new Image("res/over", 8);
        image2.imageGenerator();
        Thread.sleep(1250);
        Display.clearScreen();

    }

    public void victory() throws IOException, InterruptedException{
        Image image=new Image("res/victory.clj", 8);
        image.imageGenerator();
        Thread.sleep(1250);
        Display.clearScreen();
        Image image2=new Image("res/You", 7);
        image2.imageGenerator();
        Thread.sleep(1000);
        Image image3=new Image("res/won", 7);
        image3.imageGenerator();
    }

    public void defeat() throws IOException, InterruptedException{
        Image image=new Image("res/Defeat", 8);
        image.imageGenerator();
        Thread.sleep(1250);
        Display.clearScreen();
        Image image2=new Image("res/You", 7);
        image2.imageGenerator();
        Thread.sleep(1000);
        Image image3=new Image("res/lose", 7);
        image3.imageGenerator();
    }

}



