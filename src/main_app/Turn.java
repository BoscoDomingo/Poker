package main_app;

public class Turn {
    private int pot;
    private int turnNumber;
    private int highestCombination;
    private int currentPlayer;

    public Turn(int turnNumber, int currentPlayer) {
        this.pot = 0;
        this.turnNumber = turnNumber;
        this.highestCombination = 0;
        this.currentPlayer = currentPlayer;
    }
}
