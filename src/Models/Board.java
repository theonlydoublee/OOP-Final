package Models;

import Program.Colors;

import java.util.Arrays;
import java.util.Random;

public class Board extends Prompts{
    private int height = 6;
    private int width =  7;
    private int connect = 4;

    private String[][] boardData = new String[height][width];
    
    public void setHeight(int height) {
        this.height = height;
    }
    
    public int getConnect() {
        return connect;
    }
    
    public void setConnect(int connect) {
        this.connect = connect;
    }
    
    public int getHeight() {
        return height;
    }
    
    public int getWidth() {
        return width;
    }
    
    public void setWidth(int width) {
        this.width = width;
    }
    
    private void setDefaultBoardData(){
        //boardData = new String[height][width];
        
        for (String[] boardDatum : boardData) {
            Arrays.fill(boardDatum, "◍");
        }
    }

    public void playGame(Player player1, Player player2){
        setDefaultBoardData();
        
        int startingPlayer = genRandom(2);
        Player currentPlayer;
        if (startingPlayer == 0) {
            currentPlayer = player1;
            player1.setColor(Colors.YELLOW);
            player1.setChip("◎");
            player2.setColor(Colors.RED);
            player2.setChip("◉");
        }
        else {
            currentPlayer = player2;
            player2.setColor(Colors.YELLOW);
            player2.setChip("◎");
            player1.setColor(Colors.RED);
            player1.setChip("◉");
    
        }
    
        int turn = 1;
        Play:
        while (turn <= (height * width)){
            int play;
            int playRow = 0;

            printBoardData();

            if (!currentPlayer.isComputer()) {
                play = promptForInt(0, width, currentPlayer.getName() + " Column (1-" + width + "): ") - 1;
            }
            else {
                System.out.println(currentPlayer.getName() + " the computer played");
                play = genRandom(width);
            }

            //drop the checker
            for (int row = boardData.length-1; row >= 0; row--){
                if(boardData[row][play].equals("◍")){
                    boardData[row][play] = currentPlayer.getChip();
                    playRow = row;
                    break;
                }else if (!boardData[0][play].equals("◍")){
                    System.out.println("Choose a different column");
                    continue Play;
                }
            }
            
            if (checkWin(currentPlayer.getChip(), playRow, play)) {
                System.out.printf("\n\nWinner is %s", currentPlayer.getName());
                printBoardData();
                break;
            }

            //switch players
            if (currentPlayer == player1) {
                currentPlayer = player2;
            }
            else {
                currentPlayer = player1;
            }
            turn++;
        }
        if (turn == height*width){
            printBoardData();
            System.out.println("\n\tThere was a tie, no one wins\n");
        }


    }

    private boolean checkWin(String player, int rowIndex, int colIndex){
        int counter = 1;
        //right
        for (int i = 1; i < connect; i++) {
            try {
                if (boardData[rowIndex][colIndex+i].equals(player)){
                    counter++;
                }else {
                    break;
                }
            }catch (ArrayIndexOutOfBoundsException ignored){}
        }
        //left
        for (int i = 1; i < connect; i++) {
            try {
                if (boardData[rowIndex][colIndex-i].equals(player)){
                    counter++;
                }else {
                    break;
                }
            }catch (ArrayIndexOutOfBoundsException ignored){}
        }
        if (counter >= connect){
            return true;
        }
        counter = 1;
        //down
        for (int i = 1; i < connect; i++) {
            try {
                if (boardData[rowIndex+i][colIndex].equals(player)){
                    counter++;
                }else {
                    break;
                }
            }catch (ArrayIndexOutOfBoundsException ignored){}
        }
        if (counter >= connect){
            return true;
        }
        counter = 1;
    
        //right up diagonal
        for (int i = 1; i < connect; i++) {
            try {
                if (boardData[rowIndex-i][colIndex+i].equals(player)){
                    counter++;
                }else {
                    break;
                }
            }catch (ArrayIndexOutOfBoundsException ignored){}
        
        }
        //left down diagonal
        for (int i = 1; i < connect; i++) {
            try {
                if (boardData[rowIndex+i][colIndex-i].equals(player)){
                    counter++;
                }else {
                    break;
                }
            }catch (ArrayIndexOutOfBoundsException ignored){}
        }
        if (counter >= connect){
            return true;
        }
        counter = 1;
    
        //right down diagonal
        for (int i = 1; i < connect; i++) {
            try {
                if (boardData[rowIndex+i][colIndex+i].equals(player)){
                    counter++;
                }else {
                    break;
                }
            }catch (ArrayIndexOutOfBoundsException ignored){}
        
        }
        //left up diagonal
        for (int i = 1; i < connect; i++) {
            try {
                if (boardData[rowIndex-i][colIndex-i].equals(player)){
                    counter++;
                }else {
                    break;
                }
            }catch (ArrayIndexOutOfBoundsException ignored){}
        }
        if (counter >= connect){
            return true;
        }
        counter = 1;
        return false;
    }
    
    private int genRandom(int max){
        Random random = new Random();
        return random.nextInt(max);
    }

    private void printBoardData(){
        System.out.println("\n");
        for (int i = 0; i < boardData.length; i++) { //rows
            for (int j = 0; j < boardData[0].length; j++) { //column in each row
                System.out.print(((boardData[i][j].equals("◍")) ? "◍" : ((boardData[i][j].equals("◎")) ? (Colors.YELLOW + "◎" + Colors.RESET) : (Colors.RED + "◉" + Colors.RESET))) + " ");
            }
            System.out.println();
        }
    }
}
