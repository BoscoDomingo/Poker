package main_app.rounds;

import main_app.Deck;
import main_app.Player;

public class BettingRound extends Round {
    private int pot;
    private int minimumBet;
    private int fullCircles;
    private int[] startingBalances;

    public BettingRound(Player[] stillPlayingAfterDraws, int startingPlayer) {
        this.pot = 0;
        this.minimumBet = 100;
        this.fullCircles = 0;
        this.stillPlaying = stillPlayingAfterDraws;
        this.startingPlayer = startingPlayer;
        this.startingBalances = new int[stillPlayingAfterDraws.length];
    }

    private boolean allMatched(int minimumBet, Player[] players) {
        
    }

    //TODO: Change this shit so it allows for several bets to be placed, including forcing match. Maybe once everyone's
    //placed their bet, we can check if the remaining active players matched the highest bet, if it's gone over 3 full circles
    //or if they went all in (in case they can't match the highest bet they have no other option)
    @Override
    public int start(Player[] players, Deck deck) {
        for (int i = 0; i < players.length; i++) {
            startingBalances[i] = players[i].getBalance();
        }
        do {
            if (stillPlaying[currentPlayer] != null) {
                int[] action = players[currentPlayer].bettingAction(minimumBet);
                switch (action[0]) {
                    case 0:
                        this.pot += minimumBet;
                        players[startingPlayer].setBalance(players[startingPlayer].getBalance() - minimumBet);
                        break;
                    case 1:
                        this.pot += action[1];
                        players[startingPlayer].setBalance(players[startingPlayer].getBalance() - action[1]);
                        this.minimumBet = action[1];
                        break;
                    case 2:
                        this.stillPlaying[startingPlayer] = null;
                        break;
                }
            }
            this.currentPlayer = (this.currentPlayer + 1) % players.length;
            if (isRoundDone()) {
                fullCircles++;
            }
        } while (!isRoundDone() && allMatched() || fullCircles == 3);
        return this.pot;
    }
}
