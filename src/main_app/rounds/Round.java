package main_app.rounds;

import main_app.*;
import java.util.ArrayList;
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

    public abstract void start(Player[] players, Deck deck);

    public abstract void start(Player[] players);
}
