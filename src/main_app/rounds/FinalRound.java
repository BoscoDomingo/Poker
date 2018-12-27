package main_app.rounds;

import main_app.Deck;
import main_app.Player;

import java.util.ArrayList;

public class FinalRound extends Round {
    private int highestCombination;
    private ArrayList<Integer> playersWithHighestCombination;

    public FinalRound(Player[] players, Deck deck) {
        super(players, deck);
        this.highestCombination = 0;
        this.playersWithHighestCombination = new ArrayList<>();
    }

    @Override
    public int start(Player[] players, Deck deck) {
        int winner = -1;

        return winner;
    }
}
