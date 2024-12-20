package bitFight;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Input {
    private String input = "";
    private ArrayList<String> inputRange;
    private static BufferedReader in= new BufferedReader( new InputStreamReader(System.in));


    public String getInput() {
        return input;
    }

    public ArrayList<String> getInputRange() {
        return inputRange;
    }

    public void setInput(String input) throws InvalidInputException {
        this.input = input;
        if (!validInput()) {
            throw new InvalidInputException(getInputRange().toString());
        }
        System.out.println(input);

    }

    public void newInput(Scanner in) throws IOException {
        
        do {
            try {
                    setInput(in.nextLine());
            } catch (InvalidInputException e) {
                    Display.newPrintln(e.getMessage());
            } catch (Exception e) {
                System.err.println(e.getMessage()+": Contact support");
            }
        }
        while (!validInput());
    }

    public Input() {
        this.inputRange = new ArrayList<>();
        this.inputRange.add("q"); //Commande pour quitter
        this.inputRange.add("a"); //Commande pour attaquer
        for (Attack a : Attack.values()) this.inputRange.add(a.getName());
        for (Defense d : Defense.values()) this.inputRange.add(d.getName());
    }

    public boolean validInput() {
        boolean valid = false;
        for(String s : inputRange) if (s.equals(input)) valid = true;
        return valid;
    }
}
