package main_app;

public class Turn {
    private int pot;
    private int turnNumber;
    private int highestCombination;
    private int currentPlayer;

    public Turn(int currentPlayer) {
        this.pot = 0;
        this.turnNumber = 1;
        this.highestCombination = 0;
        this.currentPlayer = currentPlayer;
    }

    public int getPot() {
        return pot;
    }

    public void setPot(int pot) {
        this.pot = pot;
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    public void setTurnNumber(int turnNumber) {
        this.turnNumber = turnNumber;
    }

    public int getHighestCombination() {
        return highestCombination;
    }

    public void setHighestCombination(int highestCombination) {
        this.highestCombination = highestCombination;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}
