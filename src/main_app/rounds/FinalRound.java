/*
 * Copyright (c) 2018. Bosco Domingo & Luis de Marcos
 */

package main_app.rounds;

import main_app.Combinations;
import main_app.Deck;
import main_app.Player;

import java.util.ArrayList;

public class FinalRound extends Round {

    public FinalRound(boolean[] stillPlayingAfterBets, int startingPlayer) {
        this.stillPlaying = stillPlayingAfterBets;
        this.startingPlayer = startingPlayer;
        this.currentPlayer = startingPlayer;
    }

    @Override
    public int start(Player[] players, Deck deck) {
        return checkBestPlayer(players);
    }


    private int checkBestPlayer(Player[] players) {
        int bestCombination = 0, combination;
        int bestPlayer = -1;
        ArrayList<Player> bestPlayers = new ArrayList<>();

        do {
            if (stillPlaying[currentPlayer]) {
                combination = Combinations.checkCombinations(players[currentPlayer].getHand());
                System.out.print(players[currentPlayer].getName() + ". ");
                players[currentPlayer].getHand().printHand();
                System.out.print("You best Combination is: ");
                Combinations.printCombination(combination);
                if (combination > bestCombination) {
                    bestPlayers.clear();
                    bestPlayers.add(players[currentPlayer]);
                    bestCombination = combination;
                } else if (combination == bestCombination) {
                    bestPlayers.add(players[currentPlayer]);
                }
            }
            this.currentPlayer = (this.currentPlayer + 1) % players.length;
        } while (!isRoundDone());

        if (bestCombination == 1) {
            tiebreaker(players, bestPlayers);
        }
        if (bestPlayers.size() == 1) {
            bestPlayer = bestPlayers.get(0).getId();
        }
        return bestPlayer;
    }

    private void tiebreaker(Player[] players, ArrayList<Player> bestPlayers) {
        int highestCard = 0;
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
}
