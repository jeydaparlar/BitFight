package bitFight;

public class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super ("Invalid Input: \n Available inputs : \n"+message+"\n");
    }
}

