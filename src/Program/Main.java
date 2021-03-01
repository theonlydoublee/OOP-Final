package Program;

import Connect4.Connect4;
import RPS.Run;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static lib.ConsoleIO.promptForMenuSelection;
import static lib.ConsoleIO.promptForString;

public class Main {
    
    public static void main(String[] args) {
    
    
        //also stat tracker
        Player playerOne = new Player();
        Player playerTwo = new Player();
        playerOne.setName(promptForString("PLayer 1 Name: "));
        playerTwo.setName(promptForString("PLayer 2 Name: "));
    
        int winner = 0;
    
        String[] menu = {"Connect 4", "Rock Paper Scissors", "Tic-Tac-Toe", "Exit"};
    
        do {
            winner = 0;
            System.out.printf("\n\tCurrent Score:\n\t%s: %d\t%s: %d", playerOne.getName(), playerOne.getWins(), playerTwo.getName(), playerTwo.getWins());
        
            System.out.println("\n\nWhat Game do you want to play?");
            switch (promptForMenuSelection(menu, true)) {
                case 0:
                    System.out.println("\n ________  ________  ________   ________   _______   ________ _________        ___   ___     \n" +
                            "|\\   ____\\|\\   __  \\|\\   ___  \\|\\   ___  \\|\\  ___ \\ |\\   ____\\\\___   ___\\     |\\  \\ |\\  \\    \n" +
                            "\\ \\  \\___|\\ \\  \\|\\  \\ \\  \\\\ \\  \\ \\  \\\\ \\  \\ \\   __/|\\ \\  \\___\\|___ \\  \\_|     \\ \\  \\\\_\\  \\   \n" +
                            " \\ \\  \\    \\ \\  \\\\\\  \\ \\  \\\\ \\  \\ \\  \\\\ \\  \\ \\  \\_|/_\\ \\  \\       \\ \\  \\       \\ \\______  \\  \n" +
                            "  \\ \\  \\____\\ \\  \\\\\\  \\ \\  \\\\ \\  \\ \\  \\\\ \\  \\ \\  \\_|\\ \\ \\  \\____   \\ \\  \\       \\|_____|\\  \\ \n" +
                            "   \\ \\_______\\ \\_______\\ \\__\\\\ \\__\\ \\__\\\\ \\__\\ \\_______\\ \\_______\\  \\ \\__\\             \\ \\__\\\n" +
                            "    \\|_______|\\|_______|\\|__| \\|__|\\|__| \\|__|\\|_______|\\|_______|   \\|__|              \\|__|\n");
                    winner = Connect4.run(playerOne, playerTwo);
                    playerOne.setColor("\033[0m");
                    playerTwo.setColor("\033[0m");
                    break;
                case 1:
                    for (int i = 0; i < 6; i++) {
                        String rock = null;
                        String paper = null;
                        String scissors = null;
                    
                        try {
                            rock = Files.readAllLines(Paths.get("src/RPS/art.txt")).get(1 + i);
                            paper = Files.readAllLines(Paths.get("src/RPS/art.txt")).get(8 + i);
                            scissors = Files.readAllLines(Paths.get("src/RPS/art.txt")).get(15 + i);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    
                    
                        System.out.printf("%-25s%-25s%-25s\n", rock, paper, scissors);
                    
                    }
                    winner = Run.menu(playerOne, playerTwo);
                    break;
                case 2:
                    System.out.println("\n _________  ___  ________               _________  ________  ________               _________  ________  _______      \n" +
                            "|\\___   ___\\\\  \\|\\   ____\\             |\\___   ___\\\\   __  \\|\\   ____\\             |\\___   ___\\\\   __  \\|\\  ___ \\     \n" +
                            "\\|___ \\  \\_\\ \\  \\ \\  \\___|  ___________\\|___ \\  \\_\\ \\  \\|\\  \\ \\  \\___|  ___________\\|___ \\  \\_\\ \\  \\|\\  \\ \\   __/|    \n" +
                            "     \\ \\  \\ \\ \\  \\ \\  \\    |\\____________\\  \\ \\  \\ \\ \\   __  \\ \\  \\    |\\____________\\  \\ \\  \\ \\ \\  \\\\\\  \\ \\  \\_|/__  \n" +
                            "      \\ \\  \\ \\ \\  \\ \\  \\___\\|____________|   \\ \\  \\ \\ \\  \\ \\  \\ \\  \\___\\|____________|   \\ \\  \\ \\ \\  \\\\\\  \\ \\  \\_|\\ \\ \n" +
                            "       \\ \\__\\ \\ \\__\\ \\_______\\                \\ \\__\\ \\ \\__\\ \\__\\ \\_______\\                \\ \\__\\ \\ \\_______\\ \\_______\\\n" +
                            "        \\|__|  \\|__|\\|_______|                 \\|__|  \\|__|\\|__|\\|_______|                 \\|__|  \\|_______|\\|_______|\n");
                    winner = 0;
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        
            if (winner == 1) {
                playerOne.setWins(playerOne.getWins() + 1);
            } else if (winner == 2) {
                playerTwo.setWins(playerTwo.getWins() + 1);
            }
        
        } while (true);
    
    
    }
}
