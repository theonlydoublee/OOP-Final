package Connect4;


import Program.Player;

import static lib.ConsoleIO.promptForInt;

public class Connect4 {
    public Connect4() {
    }
    
    public static int run(String player1Name, String player2Name) {
        Board board = new Board();
        Player playerOne = new Player();
        Player playerTwo = new Player();
        switch (promptForInt(0, 2, "How would you like to play?\n\t1) Human v Human\n\t2) Human v Comp\n\n\t0) Exit\n\n\t\tChoice: ")) {
            case 1:
                playerOne.setName(player1Name);
                playerOne.setComputer(false);
                playerTwo.setName(player2Name);
                playerTwo.setComputer(false);
                return board.playGame(playerOne, playerTwo);
            case 2:
                playerOne.setName(player1Name);
                playerOne.setComputer(false);
                playerTwo.setName(player2Name);
                playerTwo.setComputer(true);
                return board.playGame(playerOne, playerTwo);
            case 0:
            default:
                return 0;
        }
    }
}
