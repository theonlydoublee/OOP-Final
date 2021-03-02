public class TicTacToeHuman extends TicTacToePlayer{
    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public int[] moveChoice() {
        int colPlacement = TicTacToeMenu.promptForInt("Select which column you'd like to place your piece: ",1, 3);
        int rowPlacement = TicTacToeMenu.promptForInt("Select which row you'd like to place your piece in: ", 1,3);
        int[] pieceArray = new int[] {colPlacement-1,rowPlacement-1};
        return pieceArray;
    }
}
