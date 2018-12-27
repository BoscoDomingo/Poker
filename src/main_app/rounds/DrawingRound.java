package main_app.rounds;

import main_app.Deck;
import main_app.Player;

public class DrawingRound extends Round {

    public DrawingRound(Player[] players, Deck deck) {
        super(players, deck);
    }

    public int start(Player[] players, Deck deck) {
        while (!isRoundDone()) {
            if (stillPlaying[currentPlayer] != null) {
                int howManyCards = players[currentPlayer].askForXCards();
                boolean keepPlaying = true;
                if (howManyCards != 0) {
                    players[currentPlayer].drawFromDeck(deck.pickXCards(howManyCards));
                    keepPlaying = players[currentPlayer].askIfStillPlaying();
                    if (!keepPlaying) {
                        this.stillPlaying[currentPlayer] = null;
                    }
                }
            }
            this.currentPlayer = (this.currentPlayer + 1) % players.length;
        }
        return 0;
    }

}
