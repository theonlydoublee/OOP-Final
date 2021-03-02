import java.io.IOException;
import java.util.Random;

public class TicTacToeBoard {
    
    public class GameBoard {
        private final Random random = new Random();
        char[][] char2darray = new char[3][3];
        String input;
        int userChoice = -1;
        TicTacToePlayer player1;
        TicTacToePlayer player2;
        boolean a = false;
        boolean b = false;
        boolean c = false;
        
        public int randomNum() {
            return random.nextInt(2);
        }
        
        public void clearBoard() {
            char2darray = new char[3][3];
        }
        
        public void print2DArray(char[][] charCollection) {
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

        public boolean horizontalWin(int col, int row, char winPiece) {
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

        public boolean verticalWin(int col, int row, char winPiece) {
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

        public boolean diagonalWinDownRight(int col, int row, char winPiece) {
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

        public boolean diagonalWinDownLeft(int col, int row, char winPiece) {
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

        public boolean checkForWin(int col, int row, char winPiece) {
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

        public boolean checkForEachWin(char winPiece) {
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (checkForWin(col, row, winPiece)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public void placePiece(int[] rowCol, char winPiece) {
            if (rowCol[0] == -1 || rowCol[0] == -2 || rowCol[1] == -1 || rowCol[1] == -2) {
                throw new IllegalArgumentException("This selection is full, choose another.");
            } else {
                char2darray[rowCol[0]][rowCol[1]] = winPiece;
            }
        }

        public void HumanVsHuman() {
            clearBoard();
            do {
                do {
                    try {
                        print2DArray(char2darray);
                        int[] pC = player1.moveChoice();
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
                            int[] pC2 = player2.moveChoice();
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
            }
            if (b) {
                TicTacToeMenu.printMessage(player2.getName() + " won!");
            }
        }

        public void HumanVsComputer() {
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
                            int[] pC = player1.moveChoice();
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
                            int[] pC2 = player2.moveChoice();
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
            }
            if (b) {
                TicTacToeMenu.printMessage(player2.getName() + " won!");
            }
        }

        public void ComputerVsComputer() {
            clearBoard();
            do {
                do {
                    try {
                        print2DArray(char2darray);
                        int[] pC = player1.moveChoice();
                        placePiece(pC, 'X');
                        a = checkForEachWin('X');
                        System.out.println(player1.getName() + " placed a piece in column: " + (pC[0] + 1));
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
                            int[] pC2 = player2.moveChoice();
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
            }
            if (b) {
                TicTacToeMenu.printMessage(player2.getName() + " won!");
            }
        }

        public void runTTT() throws IOException {
            do {
                userChoice = new TicTacToeMenu().InterfaceMenu();
                String player1Name = TicTacToeMenu.promptForString("Input your name: ");
                String player2Name = TicTacToeMenu.promptForString("Input your name: ");
                clearBoard();
                print2DArray(char2darray);
                switch (userChoice) {
                    case 1:
                        player1 = new TicTacToeHuman();
                        player2 = new TicTacToeHuman();
                        if (randomNum() == 0) {
                            player1.setName(player1Name);
                            player2.setName(player2Name);
                            System.out.println(player1.getName() + " is going first: ");
                        } else {
                            player1.setName(player2Name);
                            player2.setName(player1Name);
                            System.out.println(player1.getName() + " is going first: ");
                        }
                        //^^ check for a value and if true assign a player with a piece
                        HumanVsHuman();
                        break;
                    case 2:
                        player1 = new TicTacToeHuman();
                        player2 = new TicTacToeComputer();
                        player1.setName(player1Name);
                        player2.setName(player2Name);

                        HumanVsComputer();
                        break;
                    case 3:
                        player1 = new TicTacToeComputer();
                        player2 = new TicTacToeComputer();
                        if (randomNum() == 0) {
                            player1.setName(player1Name);
                            player2.setName(player2Name);
                            System.out.println(player1.getName() + " is going first: ");
                        } else {
                            player1.setName(player2Name);
                            player2.setName(player1Name);
                            System.out.println(player2.getName() + " is going first: ");
                        }

                        ComputerVsComputer();
                        break;
                    case 4:
                        break;
                }
            } while (userChoice != 4);
        }
    }
}

