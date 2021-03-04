package Connect4;

import Program.Player;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Random;

import static lib.ConsoleIO.promptForInt;

public class Board {
    private final int height = 6;
    private final int width = 7;
    private final int connect = 4;
    private final String[][] boardData;
    
    public Board() {
        this.boardData = new String[this.height][this.width];
    }
    
    private void setDefaultBoardData() {
        String[][] var1 = this.boardData;
        int var2 = var1.length;
        
        for (int var3 = 0; var3 < var2; ++var3) {
            String[] boardDatum = var1[var3];
            Arrays.fill(boardDatum, "◍");
        }
        
    }
    
    public int playGame(Player player1, Player player2) {
        this.setDefaultBoardData();
        int startingPlayer = this.genRandom(2);
        Player currentPlayer;
        if (startingPlayer == 0) {
            currentPlayer = player1;
            player1.setChip("◎");
            player2.setChip("◉");
        } else {
            currentPlayer = player2;
            player2.setChip("◎");
            player1.setChip("◉");
        }
        
        int turn = 1;
        
        while (true) {
            label51:
            while (turn <= this.height * this.width) {
                int playRow = 0;
                this.printBoardData();
                int play;
    
    
                if (!currentPlayer.isComputer()) {
                    int var10001 = this.width;
                    String var10002 = currentPlayer.getName();
                    play = promptForInt(0, var10001, var10002 + " Column (1-" + this.width + "): ") - 1;
                } else {
                    System.out.println(currentPlayer.getName() + " the computer played");
                    play = this.genRandom(this.width);
                }
    
    
                for (int row = this.boardData.length - 1; row >= 0; --row) {
                    if (this.boardData[row][play].equals("◍")) {
                        this.boardData[row][play] = currentPlayer.getChip();
                        playRow = row;
                        break;
                    }
                    
                    if (!this.boardData[0][play].equals("◍")) {
                        System.out.println("Choose a different column");
                        continue label51;
                    }
                }
                
                if (this.checkWin(currentPlayer.getChip(), playRow, play)) {
                    System.out.printf("\n\nWinner is %s", currentPlayer.getName());
                    this.printBoardData();
                    if (currentPlayer == player1) {
                        return 1;
                    } else {
                        return 2;
                    }
                }
                
                if (currentPlayer == player1) {
                    currentPlayer = player2;
                } else {
                    currentPlayer = player1;
                }
                
                ++turn;
            }
            
            this.printBoardData();
            System.out.println("\n\tThere was a tie, no one wins\n");
            return 0;
        }
    }
    
    private boolean checkWin(String player, int rowIndex, int colIndex) {
        int counter = 1;
        
        int i;
        for (i = 1; i < this.connect; ++i) {
            try {
                if (!this.boardData[rowIndex][colIndex + i].equals(player)) {
                    break;
                }
                
                ++counter;
            } catch (ArrayIndexOutOfBoundsException var13) {
            }
        }
        
        for (i = 1; i < this.connect; ++i) {
            try {
                if (!this.boardData[rowIndex][colIndex - i].equals(player)) {
                    break;
                }
                
                ++counter;
            } catch (ArrayIndexOutOfBoundsException var12) {
            }
        }
        
        if (counter >= this.connect) {
            return true;
        } else {
            counter = 1;
            
            for (i = 1; i < this.connect; ++i) {
                try {
                    if (!this.boardData[rowIndex + i][colIndex].equals(player)) {
                        break;
                    }
                    
                    ++counter;
                } catch (ArrayIndexOutOfBoundsException var11) {
                }
            }
            
            if (counter >= this.connect) {
                return true;
            } else {
                counter = 1;
                
                for (i = 1; i < this.connect; ++i) {
                    try {
                        if (!this.boardData[rowIndex - i][colIndex + i].equals(player)) {
                            break;
                        }
                        
                        ++counter;
                    } catch (ArrayIndexOutOfBoundsException var10) {
                    }
                }
                
                for (i = 1; i < this.connect; ++i) {
                    try {
                        if (!this.boardData[rowIndex + i][colIndex - i].equals(player)) {
                            break;
                        }
                        
                        ++counter;
                    } catch (ArrayIndexOutOfBoundsException var9) {
                    }
                }
                
                if (counter >= this.connect) {
                    return true;
                } else {
                    counter = 1;
                    
                    for (i = 1; i < this.connect; ++i) {
                        try {
                            if (!this.boardData[rowIndex + i][colIndex + i].equals(player)) {
                                break;
                            }
                            
                            ++counter;
                        } catch (ArrayIndexOutOfBoundsException var8) {
                        }
                    }
                    
                    for (i = 1; i < this.connect; ++i) {
                        try {
                            if (!this.boardData[rowIndex - i][colIndex - i].equals(player)) {
                                break;
                            }
                            
                            ++counter;
                        } catch (ArrayIndexOutOfBoundsException var7) {
                        }
                    }
                    
                    return counter >= this.connect;
                }
            }
        }
    }
    
    private int genRandom(int max) {
        Random random = new Random();
        return random.nextInt(max);
    }
    
    private void printBoardData() {
        System.out.println("\n");
        
        for (int i = 0; i < this.boardData.length; ++i) {
            for (int j = 0; j < this.boardData[0].length; ++j) {
                PrintStream var10000 = System.out;
                String var10001 = this.boardData[i][j].equals("◍") ? "◍" : (this.boardData[i][j].equals("◎") ? "\u001b[0;33m◎\u001b[0m" : "\u001b[0;31m◉\u001b[0m");
                var10000.print(var10001 + " ");
            }
            
            System.out.println();
        }
        
    }
}
