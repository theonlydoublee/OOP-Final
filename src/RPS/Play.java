package RPS;

import Program.Player;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static lib.ConsoleIO.promptForMenuSelection;

public class Play {
    public static int play(Player playerOne, Player playerTwo) {
        String[] choices = {"Rock", "Paper", "Scissors"};
        
        playerOne.setChip(choices[promptForMenuSelection(choices, false)]);
        
        
        if (!playerTwo.isComputer())
            playerTwo.setChip(choices[promptForMenuSelection(choices, false)]);
        else {
            playerTwo.setChip(choices[(int) (Math.random() * (3 + 1))]);
        }
        printGame(playerOne, playerTwo);
        return checkWin(playerOne, playerTwo);
    }
    
    
    private static int checkWin(Player playerOne, Player playerTwo) {
        String playerOneChoice = playerOne.getChip();
        String playerTwoChoice = playerTwo.getChip();
        
        if (playerOneChoice.equals(playerTwoChoice)) {
            System.out.println("\tTie - No Winner");
            return 0;
        }
        
        switch (playerOneChoice) {
            case "Rock":
                if (playerTwoChoice.equals("Paper")) {
                    System.out.println("Paper covers rock\n" + playerTwo.getName() + " wins");
                    return 2;
                } else if (playerTwoChoice.equals("Scissors")) {
                    System.out.println("Rock crushes scissors\n" + playerOne.getName() + " wins");
                    return 1;
                }
                break;
            case "Paper":
                if (playerTwoChoice.equals("Rock")) {
                    System.out.println("Paper covers rock\n" + playerOne.getName() + " wins");
                    return 1;
                }
                if (playerTwoChoice.equals("Scissors")) {
                    System.out.println("Rock crushes scissors\n" + playerTwo.getName() + " wins");
                    return 2;
                }
                break;
            case "Scissors":
                if (playerTwoChoice.equals("Rock")) {
                    System.out.println("Rock crushes scissors\n" + playerOne.getName() + " wins");
                    return 2;
                }
                if (playerTwoChoice.equals("Paper")) {
                    System.out.println("Scissors cut paper\n" + playerOne.getName() + " wins");
                    return 1;
                }
                break;
        }
        
        
        return 0;
    }
    
    
    public static void printGame(Player playerOne, Player playerTwo) {
        
        for (int i = 0; i < 6; i++) {
            String one = null;
            String two = null;
            
            try {
                switch (playerOne.getChip()) {
                    case "Rock":
                        one = Files.readAllLines(Paths.get("src/RPS/art.txt")).get(1 + i);
                        break;
                    case "Paper":
                        one = Files.readAllLines(Paths.get("src/RPS/art.txt")).get(8 + i);
                        break;
                    case "Scissors":
                        one = Files.readAllLines(Paths.get("src/RPS/art.txt")).get(15 + i);
                        break;
                }
                switch (playerTwo.getChip()) {
                    case "Rock":
                        two = Files.readAllLines(Paths.get("src/RPS/art.txt")).get(23 + i);
                        break;
                    case "Paper":
                        two = Files.readAllLines(Paths.get("src/RPS/art.txt")).get(30 + i);
                        break;
                    case "Scissors":
                        two = Files.readAllLines(Paths.get("src/RPS/art.txt")).get(37 + i);
                        break;
                }
                System.out.printf("%-25s%-25s\n", one, two);
                
                
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
