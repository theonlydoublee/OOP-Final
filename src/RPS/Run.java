package RPS;

import Program.Player;

import static lib.ConsoleIO.promptForInt;

public class Run {
    
    public static int menu(Player playerOne, Player playerTwo) {
        switch (promptForInt(0, 2, "How would you like to play?\n\t1) Human v Human\n\t2) Human v Comp\n\n\t0) Exit\n\n\t\tChoice: ")) {
            case 1:
                playerOne.setComputer(false);
                playerTwo.setComputer(false);
                return Play.play(playerOne, playerTwo);
            case 2:
                playerOne.setComputer(false);
                playerTwo.setComputer(true);
                return Play.play(playerOne, playerTwo);
            case 0:
            default:
                return 0;
        }
    }
}
