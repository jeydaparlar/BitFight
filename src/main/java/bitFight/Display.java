package bitFight;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Display {
    
    public static Level level;
    public static int row = 1;
    public static int dec = 10;

    public Display(Level l){
        this.level = l;
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
    }

    public static String loadTextFile(String path) throws IOException{
        FileInputStream fis = new FileInputStream(path);
        InputStreamReader instreamReader = new InputStreamReader(fis);
        BufferedReader reader = new BufferedReader(instreamReader);
        String data = "";
        while (reader.ready()){
            data += reader.readLine() + "\n";
        }
        reader.close();
        return data;
    }

    public static void setCursorPos(int row, int col){
        char escCode = 0x1B;
        System.out.print(String.format("%c[%d;%df",escCode,row,col));
    }

    public static void goToDialogBox(){
        setCursorPos(row+dec,0);
        //System.out.flush();
    }

    
    public static void clearDialogBox(){
        clearScreen();
        printDialogBox();
        setCursorPos(row,0);
        /*
        try {
            level.fightScene();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
        level.displayLifePoints();
        goToDialogBox();
    }

    public static void printDialogBox(){
        setCursorPos(100, 0);
        String dialogBox = "";
        try {
            dialogBox = loadTextFile("assets/DialogBox.text");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.getMessage();
        }
        System.out.println(dialogBox);
    }

    public static void goToUserInput(){
        setCursorPos(50, 0);
    }

    public static void newPrintln(String text){
        clearDialogBox();
        System.out.println(text);
        goToUserInput();
    }

    public static void displayNewHealthBar(){
        setCursorPos(row,0);
        level.displayLifePoints();
        goToUserInput();
    }
}
