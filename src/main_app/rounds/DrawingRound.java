package main_app.rounds;

import main_app.Deck;
import main_app.Player;

import java.util.Random;

public class DrawingRound extends Round {

    public DrawingRound(Player[] players) {
        Random r = new Random();
        this.startingPlayer = r.nextInt(players.length);
        this.currentPlayer = startingPlayer;
        this.stillPlaying = new Player[players.length];
        for (int i = 0; i < players.length; i++) {
            stillPlaying[i] = players[i];
        }
    }

    public int start(Player[] players, Deck deck) {
        do {
            int howManyCards = players[currentPlayer].askForXCards();
            boolean keepPlaying = true;
            if (howManyCards != 0) {
                players[currentPlayer].drawFromDeck(deck.pickXCards(howManyCards));
                keepPlaying = players[currentPlayer].askIfStillPlaying();
                if (!keepPlaying) {
                    this.stillPlaying[currentPlayer] = null;
                }
            }
            this.currentPlayer = (this.currentPlayer + 1) % players.length;
        } while (!isRoundDone());
        return 0;
    }

}
