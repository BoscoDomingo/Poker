package main_app.rounds;

import main_app.Combinations;
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
        winner = checkBestPlayer(players);
        return winner;
    }


    private int checkBestPlayer(Player[] players) {
        int best = 0, combination = 0;
        int bestPlayer = -1;
        ArrayList<Player> bestPlayers = new ArrayList<>();
        for (int i = 0; i < players.length; i++) {
            combination = Combinations.checkCombinations(players[i].getHand().getCards());
            if (combination > best) {
                bestPlayers.clear();
                bestPlayers.add(players[i]);
                best = combination;
            } else if (combination == best) {
                bestPlayers.add(players[i]);
            }
        }
        //Checks highest card in case of draw
        int highestCard = 0;
        if (best == 1) {
            for (int j = 0; j < players.length; j++) {
                if (players[j].getHand().getCards().get(0).getNumber() == 1) {
                    if (highestCard == 1) {
                        bestPlayers.add(players[j]);
                    } else {
                        bestPlayers.clear();
                        bestPlayers.add(players[j]);
                        highestCard = 1;
                    }
                } else if (players[j].getHand().getCards().get(4).getNumber() > highestCard && highestCard != 1) {
                    bestPlayers.clear();
                    bestPlayers.add(players[j]);
                    highestCard = players[j].getHand().getCards().get(4).getNumber();
                } else if (players[j].getHand().getCards().get(4).getNumber() == highestCard) {
                    bestPlayers.add(players[j]);
                }
            }
        }
        if (bestPlayers.size() != 2)
            bestPlayer = bestPlayers.get(0).getId();
        return bestPlayer;
    }
}
