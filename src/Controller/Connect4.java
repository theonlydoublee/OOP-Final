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
            switch (promptForInt(0,2, "How would you like to play?\n\t1) Human v Human\n\t2) Human v Comp\n\n\t0) Exit\n\n\t\tChoice: ")){
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
                case 0:
                    System.exit(0);
                    break;
            }

        }while (true);
    }

}
