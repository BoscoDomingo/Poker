package main_app.rounds;

import main_app.Deck;
import main_app.Player;

public class BettingRound extends Round {
    private int pot;
    private int minimumBet;

    public BettingRound(Player[] players, Deck deck) {
        super(players, deck);
        this.pot = 0;
        this.minimumBet = 100;
    }

    @Override
    public int start(Player[] players, Deck deck) {
        int indexOfPlayer = -1;
        for (Player currentPlayer : players) {
            indexOfPlayer++;
            int[] action = currentPlayer.bettingAction(minimumBet);
            switch (action[0]) {
                case 0:
                    this.pot += minimumBet;
                    players[indexOfPlayer].setBalance(players[indexOfPlayer].getBalance()-minimumBet);
                    break;
                case 1:
                    this.pot += action[1];
                    players[indexOfPlayer].setBalance(players[indexOfPlayer].getBalance()-action[1]);
                    this.minimumBet = action[1];
                    break;
                case 2:
                    this.stillPlaying[indexOfPlayer] = null;
                    break;
            }
        }
        return this.pot;
    }
}
