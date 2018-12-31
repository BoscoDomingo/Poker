/*
 * Copyright (c) 2018. Bosco Domingo & Luis de Marcos
 */

package main_app.rounds;

import main_app.Deck;
import main_app.Player;

import java.util.Random;

public class DrawingRound extends Round {

    public DrawingRound(Player[] players) {
        Random r = new Random();//rel. de uso
        this.startingPlayer = r.nextInt(players.length);
        this.currentPlayer = startingPlayer;
        this.stillPlaying = new boolean[players.length];

        for (int i = 0; i < players.length; i++) {
            stillPlaying[i] = true;
        }
    }

    @Override
    public int start(Player[] players, Deck deck) {
        do {
            System.out.println("Player: " + players[currentPlayer].getName() + ". Balance: " + players[currentPlayer].getBalance());
            players[currentPlayer].getHand().printHand();
            int howManyCards = players[currentPlayer].askForXCards();
            if (howManyCards != 0) {
                players[currentPlayer].drawFromDeck(deck.pickXCards(howManyCards));
                players[currentPlayer].getHand().printHand();
            }
            this.currentPlayer = (this.currentPlayer + 1) % players.length;
        } while (!isRoundDone());
        return 0;
    }

}
