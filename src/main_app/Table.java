package main_app;

public class Table {
    private Player[] players = new Player[2];
    private Turn currentTurn;


    public Table(Player[] players) {
        this.players = players;
        currentTurn = new Turn((int) Math.random());
    }

    public void startTurn() {
        currentTurn.setTurnNumber(currentTurn.getTurnNumber() + 1);
        currentTurn.setCurrentPlayer((currentTurn.getCurrentPlayer() + 1) % 2);
        currentTurn.setPot(0);
        currentTurn.setHighestCombination(0);
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public Turn getCurrentTurn() {
        return currentTurn;
    }

    public void setCurrentTurn(Turn currentTurn) {
        this.currentTurn = currentTurn;
    }
}
