package main_app;

import main_app.rounds.BettingRound;
import main_app.rounds.DrawingRound;
import main_app.rounds.FinalRound;
import main_app.rounds.Round;

public class Table {
    private Player[] players = new Player[2];
    private Round round;

    public void startRound(Deck deck) {
        deck.shuffle();
        for (int i = 0; i < players.length; i++) {
            players[i].generateHand(deck);
        }
        System.out.println("\t***************************************************\n\n\tSTART OF DRAWING ROUND");
        this.round = new DrawingRound(players, deck);
        round.start(players, deck);
        int startingPlayer = round.getStartingPlayer();
        Player[] stillPlayingAfterRound = round.getStillPlaying();
        System.out.println("\tEND OF DRAWING ROUND\n\n***************************************************\n\n\tSTART OF BETTING ROUND");

        this.round = new BettingRound(players, deck, stillPlayingAfterBets, startingPlayer);
        int pot = round.start(players, deck);//WE'RE NOT RETURNING THE LIST OF REMAINING PLAYERS...
        stillPlayingAfterRound = round.getStillPlaying();
        System.out.println("\tEND OF DRAWING ROUND\n\n***************************************************\n\n\tSTART OF SHOWDOWN");

        this.round = new FinalRound(players, deck, stillPlayingAfterRound, startingPlayer);
        int winner = round.start(players, deck);
        if (winner != -1) {
            System.out.println("Winner of the round is: " + players[winner].getName());
            players[winner].setBalance(players[winner].getBalance() + pot);
        } else {
            System.out.println("Draw!");
            for (int i = 0; i < players.length; i++) {
                players[i].setBalance(players[i].getBalance() + pot / players.length);
            }
        }
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
