package Program;

import Connect4.Connect4;
import RPS.Run;
import TicTacToe.TicTacToeBoard;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static lib.ConsoleIO.promptForMenuSelection;
import static lib.ConsoleIO.promptForString;

public class Main {
    
    public static void main(String[] args) {
        int randomColor;
    
        String resetColor = "\033[0m";
        String[] colors = {resetColor + "\033[0;30mBlack" + resetColor, resetColor + "\033[0;31mRed" + resetColor, resetColor + "\033[0;32mGreen" + resetColor, resetColor + "\033[0;33mYellow" + resetColor, resetColor + "\033[0;34mBlue" + resetColor, resetColor + "\033[0;35mPink" + resetColor, resetColor + "\033[0;36mCyan" + resetColor, resetColor + "\033[0;37mGrey" + resetColor};
    
        Player playerOne = new Player();
        Player playerTwo = new Player();
    
        playerOne.setName(promptForString("PLayer 1 Name: "));
        System.out.println("Choose player name color: ");
        playerOne.setColor(setColor(promptForMenuSelection(colors, false)));
    
        playerTwo.setName(promptForString("PLayer 2 Name: "));
        System.out.println("Choose player name color: ");
        playerTwo.setColor(setColor(promptForMenuSelection(colors, false)));
    
        int winner = 0;
    
        String[] menu = {"Connect 4", "Rock Paper Scissors", "TTT", "Exit"};
    
        do {
            winner = 0;
            System.out.printf("\n\tCurrent Score:\n\t%s: %d\t%s: %d", playerOne.getName(), playerOne.getWins(), playerTwo.getName(), playerTwo.getWins());
        
            System.out.println("\n\nWhat Game do you want to play?");
            switch (promptForMenuSelection(menu, true)) {
                case 0:
                    String connect = null;
                    randomColor = (int) (Math.random() * (8 - 1 + 1)) + 1;
                    System.out.println(setColor(randomColor));
                    for (int i = 0; i < 7; i++) {
                        try {
                            connect = Files.readAllLines(Paths.get("src/RPS/art.txt")).get(59 + i);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        System.out.printf("%-25s\n", connect);
            
                    }
                    System.out.println("\033[0m");
                    winner = Connect4.run(playerOne, playerTwo);
                    break;
                case 1:
                    String rock = null;
                    String paper = null;
                    String scissors = null;
                    String spock = null;
                    String steven = null;
                    randomColor = (int) (Math.random() * (8 - 1 + 1)) + 1;
                    System.out.println(setColor(randomColor));
                    for (int i = 0; i < 6; i++) {
                        try {
                            rock = Files.readAllLines(Paths.get("src/RPS/art.txt")).get(1 + i);
                            paper = Files.readAllLines(Paths.get("src/RPS/art.txt")).get(8 + i);
                            scissors = Files.readAllLines(Paths.get("src/RPS/art.txt")).get(15 + i);
                            spock = Files.readAllLines(Paths.get("src/RPS/art.txt")).get(45 + i);
                            steven = Files.readAllLines(Paths.get("src/RPS/art.txt")).get(52 + i);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
            
            
                        System.out.printf("%-25s%-25s%-25s%-25s%-25s\n", rock, paper, scissors, spock, steven);
            
                    }
                    System.out.println("\033[0m");
                    winner = Run.menu(playerOne, playerTwo);
                    break;
                case 2:
                    String ticTac = null;
                    randomColor = (int) (Math.random() * (8 - 1 + 1)) + 1;
                    System.out.println(setColor(randomColor));
                    for (int i = 0; i < 7; i++) {
                        try {
                            ticTac = Files.readAllLines(Paths.get("src/RPS/art.txt")).get(68 + i);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        System.out.printf("%-25s\n", ticTac);
            
                    }
        
                    System.out.println("\033[0m");
        
                    try {
                        winner = TicTacToeBoard.runTTT(playerOne, playerTwo);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    break;
                case 3:
                    System.out.println("Thanks for playing and take a Steven for your troubles");
                    String exit = null;
                    for (int i = 0; i < 6; i++) {
                        try {
                            exit = Files.readAllLines(Paths.get("src/RPS/art.txt")).get(52 + i);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        System.out.printf(setColor((int) (Math.random() * (9))));
                        System.out.printf("%-25s\n", exit);
                    }
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
    
    private static String setColor(int selection) {
        switch (selection) {
            case 0:
                return "\033[0;30m";
            case 1:
                return "\033[0;31m";
            case 2:
                return "\033[0;32m";
            case 3:
                return "\033[0;33m";
            case 4:
                return "\033[0;34m";
            case 5:
                return "\033[0;35m";
            case 6:
                return "\033[0;36m";
            case 7:
                return "\033[0;37m";
        }
        return "\033[0;37m";
    }
}
