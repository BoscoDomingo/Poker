package main_app;

import main_app.rounds.BettingRound;
import main_app.rounds.DrawingRound;
import main_app.rounds.FinalRound;
import main_app.rounds.Round;

public class Table {
    private Player[] players = new Player[2];
    private Round round;

    public void startRound(Deck deck) {
        this.round = new DrawingRound(players, deck);
        round.start(players, deck);
        System.out.println("\tEND OF DRAWING ROUND\n\n***************************************************\n\n\tSTART OF BETTING ROUND");
        this.round = new BettingRound(players, deck);
        int pot = round.start(players, deck);
        System.out.println("\tEND OF DRAWING ROUND\n\n***************************************************\n\n\tSTART OF SHOWDOWN");
        this.round = new FinalRound(players, deck);
        int winner = round.start(players, deck);
        System.out.println("Winner of the round is: " + players[winner].getName());
        players[winner].setBalance(players[winner].getBalance() + pot);
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }
}
