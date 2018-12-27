package main_app;

import java.util.ArrayList;

public class Hand {
    ArrayList<Card> cards;//should've been an array to ensure there's 5 cards at all times, but can be done through careful coding

    public Hand(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public void printHand() {
        System.out.println("Your current hand: ");
        for (Card c : cards) {
            if (cards.indexOf(c) != cards.size() - 1)
                System.out.print(c.getNumber() + "" + c.getSuit() + ", ");
            else System.out.println(c.getNumber() + "" + c.getSuit());
        }
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
}
