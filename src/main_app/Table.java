package main_app;

import main_app.rounds.DrawingRound;
import main_app.rounds.Round;

public class Table {
    private Player[] players = new Player[2];
    private Round round;

    public void startRound(Deck deck) {
        this.round = new DrawingRound(players, deck);
        round.start(players, deck);
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }
}
