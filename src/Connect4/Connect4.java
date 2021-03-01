package Connect4;


import Program.Player;

import static lib.ConsoleIO.promptForInt;

public class Connect4 {
    public Connect4() {
    }
    
    public static int run(Player playerOne, Player playerTwo) {
        Board board = new Board();
    
        switch (promptForInt(0, 2, "How would you like to play?\n\t1) Human v Human\n\t2) Human v Comp\n\n\t0) Exit\n\n\t\tChoice: ")) {
            case 1:
                playerOne.setComputer(false);
                playerTwo.setComputer(false);
                return board.playGame(playerOne, playerTwo);
            case 2:
                playerOne.setComputer(false);
                playerTwo.setComputer(true);
                return board.playGame(playerOne, playerTwo);
            case 0:
            default:
                return 0;
        }
    }
}
