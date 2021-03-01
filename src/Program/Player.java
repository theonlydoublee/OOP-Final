package Program;

public class Player {
    private String name;
    private String color = "\033[0;37m";
    private String chip;
    private boolean isComputer;
    private int wins;
    
    public boolean isComputer() {
        return this.isComputer;
    }
    
    public void setComputer(boolean computer) {
        this.isComputer = computer;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public String getName() {
        return this.color + this.name + "\u001b[0m";
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getChip() {
        return this.chip;
    }
    
    public void setChip(String chip) {
        this.chip = chip;
    }
    
    public int getWins() {
        return wins;
    }
    
    public void setWins(int wins) {
        this.wins = wins;
    }
}
