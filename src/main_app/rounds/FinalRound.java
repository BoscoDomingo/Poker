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
                combination = Combinations.checkCombinations(players[currentPlayer].getHand().getCards());
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
        int highestCard = players[0].getHand().getCards().get(4).getNumber();
        bestPlayers.clear();
        bestPlayers.add(players[0]);
        for (int i = 1; i < players.length; i++) {
            int currentHigh = players[i].getHand().getCards().get(4).getNumber();
            if (currentHigh > highestCard) {
                bestPlayers.clear();
                bestPlayers.add(players[i]);
                highestCard = currentHigh;
            } else if (currentHigh == highestCard) {
                bestPlayers.add(players[i]);
            }
        }
    }
       /* int highestCard = 0;
        for (int j = 0; j < players.length; j++) {//Y el caso de highestCard == 1, players[j].getHand().getCards().get(0).getNumber() != 1 y players[j].getHand().getCards().get(4).getNumber() != highestCard?
            if (players[j].getHand().getCards().get(0).getNumber() == 1) { //esto no tendría que ser get(4)?
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
        }*/

}
