package RPS;

import Program.Player;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static lib.ConsoleIO.promptForMenuSelection;

public class Play {
    public static int play(Player playerOne, Player playerTwo) {
        String[] choices = {"Rock", "Paper", "Scissors", "Spock", "Lizard"};
    
        playerOne.setChip(choices[promptForMenuSelection(choices, false)]);
        System.out.println(playerOne.getChip());
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
                switch (playerTwoChoice) {
                    case "Paper":
                        System.out.println("Paper covers rock\n" + playerTwo.getName() + " wins");
                        return 2;
                    case "Scissors":
                        System.out.println("Rock crushes scissors\n" + playerOne.getName() + " wins");
                        return 1;
                    case "Spock":
                        System.out.println("Spock vaporizes rock\n" + playerTwo.getName() + " wins");
                        return 2;
                    case "Lizard":
                        System.out.println("Rock crushes lizard\n" + playerOne.getName() + " wins");
                        return 1;
                }
                break;
            case "Paper":
                switch (playerTwoChoice) {
                    case "Rock":
                        System.out.println("Paper covers rock\n" + playerOne.getName() + " wins");
                        return 1;
                    case "Scissors":
                        System.out.println("Scissors cuts paper\n" + playerTwo.getName() + " wins");
                        return 2;
                    case "Spock":
                        System.out.println("Paper disproves Spock\n" + playerOne.getName() + " wins");
                        return 1;
                    case "Lizard":
                        System.out.println("Lizard eats paper\n" + playerTwo.getName() + " wins");
                        return 2;
                }
                break;
            case "Scissors":
                switch (playerTwoChoice) {
                    case "Rock":
                        System.out.println("Rock crushes scissors\n" + playerTwo.getName() + " wins");
                        return 2;
                    case "Paper":
                        System.out.println("Scissors cut paper\n" + playerOne.getName() + " wins");
                        return 1;
                    case "Spock":
                        System.out.println("Spock smashes scissors\n" + playerTwo.getName() + " wins");
                        return 2;
                    case "Lizard":
                        System.out.println("Scissors decapitates lizard\n" + playerOne.getName() + " wins");
                        return 1;
                }
                break;
            case "Spock":
                switch (playerTwoChoice) {
                    case "Rock":
                        System.out.println("Spock vaporizes rock\n" + playerOne.getName() + " wins");
                        return 1;
                    case "Paper":
                        System.out.println("Paper disproves Spock\n" + playerTwo.getName() + " wins");
                        return 2;
                    case "Scissors":
                        System.out.println("Spock smashes scissors\n" + playerOne.getName() + " wins");
                        return 1;
                    case "Lizard":
                        System.out.println("Lizard poisons Spock\n" + playerTwo.getName() + " wins");
                        return 2;
                }
                break;
            case "Lizard":
                switch (playerTwoChoice) {
                    case "Rock":
                        System.out.println("Rock crushes lizard\n" + playerTwo.getName() + " wins");
                        return 2;
                    case "Paper":
                        System.out.println("Lizard eats paper\n" + playerOne.getName() + " wins");
                        return 1;
                    case "Scissors":
                        System.out.println("Scissors decapitates lizard\n" + playerTwo.getName() + " wins");
                        return 2;
                    case "Spock":
                        System.out.println("Lizard poisons Spock\n" + playerOne.getName() + " wins");
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
                    case "Spock":
                        one = Files.readAllLines(Paths.get("src/RPS/art.txt")).get(45 + i);
                        break;
                    case "Lizard":
                        one = Files.readAllLines(Paths.get("src/RPS/art.txt")).get(52 + i);
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
                    case "Spock":
                        two = Files.readAllLines(Paths.get("src/RPS/art.txt")).get(45 + i);
                        break;
                    case "Lizard":
                        two = Files.readAllLines(Paths.get("src/RPS/art.txt")).get(52 + i);
                        break;
                }
                System.out.printf("%-40s%-40s\n", one, two);
                
                
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
