public abstract class TicTacToePlayer {
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract int[] moveChoice();
}
