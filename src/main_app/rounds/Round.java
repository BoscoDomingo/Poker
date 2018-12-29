package main_app.rounds;

import main_app.Deck;
import main_app.Player;

import java.util.Random;

public abstract class Round {

    protected int currentPlayer;
    protected int startingPlayer;
    protected Player[] stillPlaying;

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
