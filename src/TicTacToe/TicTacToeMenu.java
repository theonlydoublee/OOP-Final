package TicTacToe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TicTacToeMenu {
    
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    
    
    public static int promptForInt(String prompt, int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("The min cannot be greater than the max. min: " + min + ", max: " + max);
        }
        
        int userNum = -1;
        String input;
        boolean isInvalid = true;
        
        do {
            System.out.print(prompt);
            try {
                input = reader.readLine();
                userNum = Integer.parseInt(input);
                isInvalid = userNum < min || userNum > max;
            } catch (IOException ioe) {
                System.out.println("Whoa! Something technical went wrong. Let's try that again.");
            } catch (NumberFormatException nfe) {
                System.out.println("You didn't put in a number, try again.");
            }
            
            if (isInvalid) {
                System.out.println("You entered an invalid value. Please, try again.");
            }
        } while (isInvalid);
        
        return userNum;
    }
    
    public static void printMessage(String message){
        System.out.println(message);
    }
    
    public static String promptForString(String prompt) {
        String input = "";
        System.out.print(prompt);
        try {
            input = reader.readLine();
        } catch (IOException ioe) {
            System.out.println("Whoa! Something technical went wrong. Let's try that again.");
        }
        
        return input;
    }
    
    public int InterfaceMenu() {
        String InterfaceMenu = "Select your choice: \n1: Human vs Human \n2: Human vs Computer \n3: Computer vs Computer \n\n4: Exit. ";
        
        return promptForInt(InterfaceMenu, 1, 4);
    }
}

