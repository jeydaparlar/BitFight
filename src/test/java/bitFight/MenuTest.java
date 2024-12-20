
package bitFight;

import java.io.IOException;

public class MenuTest{

    public static void main(String[] args) throws IOException, InterruptedException {
        Menu menu= new Menu("name");
        menu.display();
        menu.validate();
        menu.displayGameRules();
        menu.validate();

        Display.clearScreen();
        System.out.println("Success!");
    }
}