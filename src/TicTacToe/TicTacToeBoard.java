package TicTacToe;

import Program.Player;

import java.io.IOException;
import java.util.Random;

public class TicTacToeBoard {
    
    static private final Random random = new Random();
    static char[][] char2darray = new char[3][3];
    String input;
    static int userChoice = -1;
    static Player player1;
    static Player player2;
    static boolean a = false;
    static boolean b = false;
    static boolean c = false;
    
    public static int randomNum() {
        return random.nextInt(2);
    }
    
    public static void clearBoard() {
        char2darray = new char[3][3];
    }
    
    public static void print2DArray(char[][] charCollection) {
        for (int row = 0; row < charCollection.length; row++) {
            for (int col = 0; col < charCollection[row].length; col++) {
                System.out.print(" | ");
                if (charCollection[row][col] == 0) {
                    System.out.print(" * ");
                } else {
                    System.out.printf("%3s", charCollection[row][col]);
                }
            }
            System.out.println("|");
        }
    }
    
    public static boolean horizontalWin(int col, int row, char winPiece) {
        int tally = 0;
        for (int i = col; i < 3; i++) {
            if (char2darray[row][i] == winPiece) {
                tally++;
            } else {
                break;
            }
            //winpiece is determining what we're looking for
            //first for loop is checking right and tallying and second for loop is checking left and tallying until it equals 4, if it's 4 it's true but if it's less then it's false
        }
        for (int i = col - 1; i > -1; i--) {
            if (char2darray[row][i] == winPiece) {
                tally++;
            } else {
                break;
            }
        }
        return tally >= 3;
    }
    
    public static boolean verticalWin(int col, int row, char winPiece) {
        int tally = 0;
        for (int i = row; i < 3; i++) {
            if (char2darray[i][col] == winPiece) {
                tally++;
            } else {
                break;
            }
        }
        for (int i = row - 1; i > -1; i--) {
            if (char2darray[i][col] == winPiece) {
                tally++;
            } else {
                break;
            }
        }
        return tally >= 3;
    }
    
    public static boolean diagonalWinDownRight(int col, int row, char winPiece) {
        int tally = 0;
        if (char2darray[row][col] == winPiece) {
            tally++;
        }
        int initialRow = row;
        int initialCol = col;
        int rowShift = 1;
        int colShift = 1;
        for (int i = 0; i < 3; i++) {
            row += rowShift;
            col += colShift;
            if (row < 0 || row > 2) {
                break;
            }
            if (col < 0 || col > 2) {
                break;
            }
            if (char2darray[row][col] == winPiece) {
                tally++;
            } else {
                break;
            }
        }
        //   \   /
        row = initialRow;
        col = initialCol;
        rowShift = -1;
        colShift = -1;
        for (int i = 0; i < 3; i++) {
            row += rowShift;
            col += colShift;
            if (row < 0 || row > 2) {
                break;
            }
            if (col < 0 || col > 2) {
                break;
            }
            if (char2darray[row][col] == winPiece) {
                tally++;
            } else {
                break;
            }
        }
        return tally >= 3;
    }
    
    public static boolean diagonalWinDownLeft(int col, int row, char winPiece) {
        int tally = 0;
        if (char2darray[row][col] == winPiece) {
            tally++;
        }
        int initialRow = row;
        int initialCol = col;
        int rowShift = 1;
        int colShift = -1;
        for (int i = 0; i < 3; i++) {
            row += rowShift;
            col += colShift;
            if (row < 0 || row > 2) {
                break;
            }
            if (col < 0 || col > 2) {
                break;
            }
            if (char2darray[row][col] == winPiece) {
                tally++;
            } else {
                break;
            }
        }
        //   \   /
        row = initialRow;
        col = initialCol;
        rowShift = -1;
        colShift = 1;
        for (int i = 0; i < 3; i++) {
            row += rowShift;
            col += colShift;
            if (row < 0 || row > 2) {
                break;
            }
            if (col < 0 || col > 2) {
                break;
            }
            if (char2darray[row][col] == winPiece) {
                tally++;
            } else {
                break;
            }
        }
        return tally >= 3;
    }
    
    public static boolean checkForWin(int col, int row, char winPiece) {
        if (horizontalWin(col, row, winPiece)) {
            return true;
        }
        if (verticalWin(col, row, winPiece)) {
            return true;
        }
        if (diagonalWinDownRight(col, row, winPiece)) {
            return true;
        }
        return diagonalWinDownLeft(col, row, winPiece);
    }
    
    public static boolean checkForEachWin(char winPiece) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (checkForWin(col, row, winPiece)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static void placePiece(int[] rowCol, char winPiece) {
    
        if (rowCol[0] == -1 || rowCol[0] == -2 || rowCol[1] == -1 || rowCol[1] == -2) {
            throw new IllegalArgumentException("This selection is full, choose another.");
        } else {
            char2darray[rowCol[0]][rowCol[1]] = winPiece;
        }
    
    }
    
    public static int HumanVsHuman() {
        clearBoard();
        do {
            do {
                try {
                    print2DArray(char2darray);
                    int[] pC = humanMoveChoice();
                    placePiece(pC, 'X');
                    a = checkForEachWin('X');
                    c = false;
                } catch (IllegalArgumentException iae) {
                    TicTacToeMenu.printMessage(iae.getMessage());
                    c = true;
                }
            } while (c);
            if (!a) {
                do {
                    try {
                        print2DArray(char2darray);
                        int[] pC2 = humanMoveChoice();
                        placePiece(pC2, 'O');
                        b = checkForEachWin('O');
                        c = false;
                    } catch (IllegalArgumentException iae) {
                        TicTacToeMenu.printMessage(iae.getMessage());
                        c = true;
                    }
                } while (c);
            }
        } while (!a && !b);
        if (a) {
            TicTacToeMenu.printMessage(player1.getName() + " won!");
            print2DArray(char2darray);
            return 1;
        }
        if (b) {
            TicTacToeMenu.printMessage(player2.getName() + " won!");
            print2DArray(char2darray);
            return 2;
        }
        print2DArray(char2darray);
        return 0;
        
    }
    
    public static int HumanVsComputer() {
        clearBoard();
        boolean player1First = (randomNum() == 0);
        char player1Char;
        char player2Char;
        if (player1First) {
            player1Char = 'X';
            player2Char = 'O';
            System.out.println(player1.getName() + " is going first: ");
        } else {
            player1Char = 'X';
            player2Char = 'O';
            System.out.println(player2.getName() + " is going first: ");
        }
        do {
            do {
                try {
                    if (player1First) {
                        print2DArray(char2darray);
                        int[] pC = humanMoveChoice();
                        placePiece(pC, player1Char);
                        a = checkForEachWin(player1Char);
                        c = false;
                    } else {
                        player1First = true;
                    }
                } catch (IllegalArgumentException iae) {
                    TicTacToeMenu.printMessage(iae.getMessage());
                    c = true;
                }
            } while (c);
            if (!a) {
                do {
                    try {
                        int[] pC2 = compMoveChoice();
                        placePiece(pC2, player2Char);
                        b = checkForEachWin(player2Char);
                        System.out.println(player2.getName() + (pC2[0] + 1));
                        c = false;
                    } catch (IllegalArgumentException iae) {
                        TicTacToeMenu.printMessage(iae.getMessage());
                        c = true;
                    }
                } while (c);
            }
        } while (!a && !b);
        if (a) {
            TicTacToeMenu.printMessage(player1.getName() + " won!");
            print2DArray(char2darray);
            return 1;
        }
        if (b) {
            TicTacToeMenu.printMessage(player2.getName() + " won!");
            print2DArray(char2darray);
            return 2;
        }
        print2DArray(char2darray);
        return 0;
    }
    
    public static int ComputerVsComputer() {
        clearBoard();
        do {
            do {
                try {
                    print2DArray(char2darray);
                    int[] pC = compMoveChoice();
                    placePiece(pC, 'X');
                    a = checkForEachWin('X');
                    System.out.println(player1.getName() + " placed a piece in row: " + (pC[0] + 1));
                    c = false;
                } catch (IllegalArgumentException iae) {
                    TicTacToeMenu.printMessage(iae.getMessage());
                    c = true;
                }
            } while (c);
            if (!a) {
                do {
                    try {
                        print2DArray(char2darray);
                        int[] pC2 = compMoveChoice();
                        placePiece(pC2, 'O');
                        b = checkForEachWin('O');
                        System.out.println(player2.getName() + " placed a piece in column: " + (pC2[0] + 1));
                        c = false;
                    } catch (IllegalArgumentException iae) {
                        TicTacToeMenu.printMessage(iae.getMessage());
                        c = true;
                    }
                } while (c);
            }
        } while (!a && !b);
        if (a) {
            TicTacToeMenu.printMessage(player1.getName() + " won!");
            print2DArray(char2darray);
            return 1;
        }
        if (b) {
            TicTacToeMenu.printMessage(player2.getName() + " won!");
            print2DArray(char2darray);
            return 2;
        }
        
        print2DArray(char2darray);
        return 0;
    }
    
    public static int runTTT(Player playerOne, Player playerTwo) throws IOException {
        player1 = playerOne;
        player2 = playerTwo;
        
        
        tic:
        do {
            userChoice = new TicTacToeMenu().InterfaceMenu();
            clearBoard();
            print2DArray(char2darray);
            switch (userChoice) {
                case 1:
//                    playerOne = new TicTacToeHuman();
//                    playerTwo = new TicTacToeHuman();
                    if (randomNum() == 0) {
//                        playerOne.setName(player1Name);
//                        playerTwo.setName(player2Name);
                        System.out.println(playerOne.getName() + " is going first: ");
                    } else {
//                        playerOne.setName(player2Name);
//                        playerTwo.setName(player1Name);
                        System.out.println(playerOne.getName() + " is going first: ");
                    }
                    //^^ check for a value and if true assign a player with a piece
                    return HumanVsHuman();
                case 2:
//                    playerOne = new TicTacToeHuman();
//                    playerTwo = new TicTacToeComputer();
//                    playerOne.setName(player1Name);
//                    playerTwo.setName(player2Name);
                    
                    return HumanVsComputer();
                case 3:
//                    playerOne = new TicTacToeComputer();
//                    playerTwo = new TicTacToeComputer();
                    if (randomNum() == 0) {
//                        playerOne.setName(player1Name);
//                        playerTwo.setName(player2Name);
                        System.out.println(playerOne.getName() + " is going first: ");
                    } else {
//                        playerOne.setName(player2Name);
//                        playerTwo.setName(player1Name);
                        System.out.println(playerTwo.getName() + " is going first: ");
                    }
                    
                    return ComputerVsComputer();
                case 4:
                    break tic;
            }
        } while (true);
        return 0;
    }
    
    private static int[] compMoveChoice() {
        do {
            int colPlacement = random.nextInt(3);
            int rowPlacement = random.nextInt(3);
            
            if (char2darray[rowPlacement][colPlacement] == 0) {
                return new int[]{rowPlacement, colPlacement};
            } else {
                System.out.println("\n\tChoosing unused zipcode");
                print2DArray(char2darray);
            }
        } while (true);
    }
    
    private static int[] humanMoveChoice() {
        do {
            int colPlacement = TicTacToeMenu.promptForInt("Select which column you'd like to place your piece: ", 1, 3) - 1;
            int rowPlacement = TicTacToeMenu.promptForInt("Select which row you'd like to place your piece in: ", 1, 3) - 1;
            
            if (char2darray[rowPlacement][colPlacement] == 0) {
                return new int[]{rowPlacement, colPlacement};
            } else {
                System.out.println("\n\tSpot is taken, choose a new zipcode");
                print2DArray(char2darray);
            }
            
        } while (true);
    }
}


