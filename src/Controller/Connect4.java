package Controller;

import Models.*;

import static Models.Prompts.promptForInt;
import static Models.Prompts.promptForText;

public class Connect4 {

    public static void run(){

        Board board = new Board();
        
        do {
            Player playerOne = new Player();
            Player playerTwo = new Player();
            switch (promptForInt(0,5, "How would you like to play?\n\t1) Human v Human\n\t2) Human v Comp\n\t3) Comp v Comp\n\t4) Change Board Size (Currently: " + board.getHeight() + " high by "
                    + board.getWidth() + " wide)\n\t5) Change Connect Amount to Win (Currently: " + board.getConnect() + ")\n\t\tChanges with board or change manually after change in board size\n\n\t0) Exit\n\n\t\tChoice: ")){
                case 1:
                    playerOne.setName(promptForText("Player One Name: "));
                    playerOne.setComputer(false);
                    playerTwo.setName(promptForText("Player Two Name: "));
                    playerTwo.setComputer(false);
                    board.playGame(playerOne, playerTwo);
                    break;
                case 2:
                    playerOne.setName(promptForText("Player One Name: "));
                    playerOne.setComputer(false);
                    playerTwo.setName(promptForText("Player Two Name: "));
                    playerTwo.setComputer(true);
                    board.playGame(playerOne, playerTwo);
                    break;
                case 3:
                    playerOne.setName(promptForText("Player One Name: "));
                    playerOne.setComputer(true);
                    playerTwo.setName(promptForText("Player Two Name: "));
                    playerTwo.setComputer(true);
                    board.playGame(playerOne, playerTwo);
                    break;
                case 4:
                    board.setWidth(promptForInt(5, 25, "Width (5-25): "));
                    board.setHeight(promptForInt(4, board.getWidth() - 1, "Height (4-" + (board.getWidth() - 1) + "): "));
                    board.setConnect(Math.min(board.getHeight(), board.getWidth())-2);
                    break;
                case 5:
                    board.setConnect(promptForInt(2, Math.min(board.getHeight(), board.getWidth())-2, "Amount to Connect to Win (2-"+ (Math.min(board.getHeight(), board.getWidth())-2) + "): "));
                    break;
                case 0:
                    System.exit(0);
                    break;
            }

        }while (true);
    }

}
