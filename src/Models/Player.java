package Models;


import Program.Colors;

public class Player {
    private String name;
    private String color;
    private String chip;
    private boolean isComputer;

    public boolean isComputer() {
        return isComputer;
    }

    public void setComputer(boolean computer) {
        isComputer = computer;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return this.color + name + Colors.RESET;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getChip() {
        return chip;
    }
    public void setChip(String chip) {
        this.chip = chip;
    }
}
