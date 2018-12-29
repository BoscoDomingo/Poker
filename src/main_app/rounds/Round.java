package main_app.rounds;

import main_app.Deck;
import main_app.Player;

import java.util.Random;

public abstract class Round {

    protected int currentPlayer;
    protected int startingPlayer;
    protected Player[] stillPlaying;

    public Round(Player[] players, Deck deck) {
        Random r = new Random();
        this.startingPlayer = r.nextInt(players.length);
        this.currentPlayer = startingPlayer;
        this.stillPlaying = new Player[players.length];
        for (int i = 0; i < players.length; i++) {
            stillPlaying[i] = players[i];
        }
    }

    protected boolean isRoundDone() {
        return this.currentPlayer == this.startingPlayer;
    }

    public abstract int start(Player[] players, Deck deck);

    public Player[] getStillPlaying() {
        return stillPlaying;
    }

    public int getStartingPlayer() {
        return startingPlayer;
    }
}
