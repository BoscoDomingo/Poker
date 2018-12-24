package main_app;

public class Table {
    private Player[] players = new Player[2];
    private Turn currentTurn;


    public Table(Player[] players) {
        this.players = players;
        currentTurn = new Turn(0, 0);
    }

    public void startTurn(){
        currentTurn
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
