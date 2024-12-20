package bitFight;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu{

    String name;

    public Menu(String name){
        this.name=name;
    }

    public void display() throws IOException, InterruptedException{
        Image image=new Image("res/logo.clj", 8);
        image.imageGenerator();
        Thread.sleep(1000);
        Image image3=new Image("res/slogan.clj", 8);
        image3.imageGenerator();
        Thread.sleep(1000);
        System.out.println('\n');
        System.out.println("      Welcome to BitFight, a combat game. Press enter to continue"+'\n');
        Image image2= new Image("res/perso-1.txt", 14);
        System.out.println("                                                   ");
        image2.imageGenerator();
    }
    public void validate() throws IOException {
        BufferedReader br= new BufferedReader( new InputStreamReader(System.in));
        char c= (char)br.read();
        char enter='\n';
        if(c!=enter){
           System.out.print("Invalid input, try again !");
           c= (char)br.read();
        }
    }

    public void displayGameRules() throws InterruptedException {
        System.out.println("To fight, type the name of an action and press enter.");
        System.out.println("To exit the game at any moment, type 'q' and press Enter.");
        System.out.println('\n');
        Thread.sleep(650);
        System.out.println("                            GAME RULES...       "+'\n');
        Thread.sleep(650);
        System.out.println("      You have 10 seconds to type the attack of your choice against your enemy.");
        Thread.sleep(650);
        System.out.println("      If you're too slow, your enemy will attack and you will loose vitality points");
        Thread.sleep(650);
        System.out.println("      If you win you will move on to the next level, but if you loose you will be ... ");
        Thread.sleep(650);
        System.out.println("      TERMINATED!");
        Thread.sleep(650);
        System.out.println('\n');
        System.out.println("      Press enter to continue...");


    }
    
}