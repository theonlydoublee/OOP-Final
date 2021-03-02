import java.util.Random;

public class TicTacToeComputer extends TicTacToePlayer{
    private Random random = new Random();
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
        int colPlacement = random.nextInt(3);
        int rowPlacement = random.nextInt(3);
        int[] pieceArray = new int[]{colPlacement,rowPlacement};
        return pieceArray;
    }
}
