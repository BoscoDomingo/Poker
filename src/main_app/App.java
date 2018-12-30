/*
 * Copyright (c) 2018. Bosco Domingo & Luis de Marcos
 */

package main_app;

public class App {
    public static void main(String[] args) {
        System.out.println("**************************************************\nWelcome to Five-Card Draw Poker\n**************************************************");
        Deck deck = new Deck();
        Card card = null;
        deck.generateDeck();
        Poker game = new Poker();
        game.startGame(deck);
    }
}
