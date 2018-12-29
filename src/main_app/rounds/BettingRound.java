package main_app.rounds;

import main_app.Deck;
import main_app.Player;

public class BettingRound extends Round {
    private int pot;
    private int minimumBet;

    public BettingRound(Player[] players, Deck deck, int startingPlayer) {
        super(players, deck);
        this.pot = 0;
        this.minimumBet = 100;
        this.startingPlayer = startingPlayer;
    }
//TODO: Change this shit so it allows for several bets to be placed, including forcing match. Maybe once everyone's
    //placed their bet, we can check if the remaining active players matched the highest bet, if it's gone over 3 full circles
    //or if they went all in (in case they can't match the highest bet they have no other option)
    @Override
    public int start(Player[] players, Deck deck) {
        int indexOfPlayer = -1; //use this.currentPlayer and this.startingPlayer
        for (Player currentPlayer : players) {
            indexOfPlayer++;
            int[] action = currentPlayer.bettingAction(minimumBet);
            switch (action[0]) {
                case 0:
                    this.pot += minimumBet;
                    players[indexOfPlayer].setBalance(players[indexOfPlayer].getBalance() - minimumBet);
                    break;
                case 1:
                    this.pot += action[1];
                    players[indexOfPlayer].setBalance(players[indexOfPlayer].getBalance() - action[1]);
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
