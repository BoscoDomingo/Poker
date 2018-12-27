package main_app.rounds;

import main_app.Deck;
import main_app.Player;

import java.util.ArrayList;

public class BettingRound extends Round {
    private int pot;
    private int highestCombination;
    private ArrayList<Integer> playersWithHighestCombination;

    public BettingRound(Player[] players, Deck deck) {
        super(players, deck);
        this.pot = 0;
        this.highestCombination = 0;
        this.playersWithHighestCombination = new ArrayList<>();
    }

    @Override
    public void start(Player[] players, Deck deck) {

    }
}
