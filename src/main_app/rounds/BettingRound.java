package main_app.rounds;

import main_app.Deck;
import main_app.Player;

public class BettingRound extends Round {
    private int pot;
    private int minimumBet;
    private int fullCircles;
    private int[] startingBalances;

    public BettingRound(boolean[] stillPlayingAfterDraws, int startingPlayer) {
        this.pot = 0;
        this.minimumBet = 100;
        this.fullCircles = 0;
        this.stillPlaying = stillPlayingAfterDraws;
        this.startingPlayer = startingPlayer;
        this.currentPlayer = startingPlayer;
        this.startingBalances = new int[stillPlayingAfterDraws.length];
    }

    @Override
    public int start(Player[] players, Deck deck) {
        for (int i = 0; i < players.length; i++) {
            startingBalances[i] = players[i].getBalance();
        }
        boolean wasRaised = false;
        do {
            wasRaised = false;
            do {
                if (stillPlaying[currentPlayer]) {
                    System.out.println("Current pot is: " + this.pot);
                    int[] action = players[currentPlayer].bettingAction(minimumBet);
                    switch (action[0]) {
                        case 0:
                            seesTheBet(players);
                            break;
                        case 1:
                            wasRaised = true;
                            raisesTheBet(players, action);
                            break;
                        case 2:
                            goesAllIn(players);
                            break;
                        case 3:
                            System.out.println(players[currentPlayer].getName() + " dropped out of this round");
                            this.stillPlaying[currentPlayer] = false;
                            break;
                    }
                }
                this.currentPlayer = (this.currentPlayer + 1) % players.length;

            } while (!isRoundDone());
            fullCircles++;
        } while (fullCircles < 3 && wasRaised);

        if (fullCircles == 3 && wasRaised) { //if it was raised on last round all players must match
            forceMatch(players);
        }

        return this.pot;
    }

    private void seesTheBet(Player[] players) {
        if (players[currentPlayer].getBalance() < minimumBet) { //going all in because they are broke
            System.out.println(players[currentPlayer].getName() + " is going All-In!!");
            this.pot += players[currentPlayer].getBalance();
            players[currentPlayer].setBalance(0);
        } else {
            System.out.println(players[currentPlayer].getName() + " sees the minimum bet of " + minimumBet);
            this.pot += minimumBet;
            players[currentPlayer].setBalance(players[currentPlayer].getBalance() - minimumBet);
        }
    }

    private void raisesTheBet(Player[] players, int[] action) {
        System.out.println(players[currentPlayer].getName() + " chose to raise the bet to " + action[1]);
        this.pot += action[1];
        players[currentPlayer].setBalance(players[currentPlayer].getBalance() - action[1]);
        this.minimumBet = action[1];
    }

    private void goesAllIn(Player[] players) {
        System.out.println(players[currentPlayer].getName() + " is going All-In!!");
        this.pot += players[currentPlayer].getBalance();
        this.minimumBet = Math.max(minimumBet, players[currentPlayer].getBalance());
        players[currentPlayer].setBalance(0);
    }

    private void forceMatch(Player[] players) {
        for (int i = 0; i < players.length; i++) {
            int currentBet = this.startingBalances[i] - players[i].getBalance();
            if (stillPlaying[i] && players[i].getBalance() != 0 && currentBet != minimumBet) {
                int differenceInBets = minimumBet - currentBet;
                if (players[i].getBalance() - differenceInBets > 0) {
                    this.pot += differenceInBets;
                    players[i].setBalance(players[i].getBalance() - differenceInBets);
                } else {
                    this.pot += players[currentPlayer].getBalance();
                    players[currentPlayer].setBalance(0);
                }
            }
        }
    }
}
