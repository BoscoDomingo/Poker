package main_app;

public class Turn {
    private int currentPlayer;
    private int startingPlayer;

    public Turn(int startingPlayer) {
        this.startingPlayer = startingPlayer;
        this.currentPlayer = startingPlayer;
    }

    public void nextPlayer(int numberOfPlayers) {
        this.currentPlayer = (this.currentPlayer + 1) % numberOfPlayers;
        if (isRoundDone()) {

        }
    }

    private boolean isRoundDone() {
        return this.currentPlayer == this.startingPlayer;
    }

    public int getStartingPlayer() {
        return startingPlayer;
    }

    public void setStartingPlayer(int startingPlayer) {
        this.startingPlayer = startingPlayer;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}
