package main_app;

import java.util.ArrayList;

public class Hand {
    ArrayList<Card> cards;

    public Hand(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public void printHand() {
        System.out.println("Your hand: ");
        for (Card c : cards) {
            if (cards.indexOf(c) != cards.size() - 1)
                System.out.print(c.getNumber() + "" + c.getSuit() + ", ");
            else System.out.println(c.getNumber() + "" + c.getSuit());
        }
    }

    public void bubbleSort() {
        int temp = 0;
        for (int i = 0; i < this.cards.size(); i++) {
            for (int j = 1; j < (this.cards.size() - i); j++) {
                if (this.cards.get(j-1).getNumber() > this.cards.get(j).getNumber()) {
                    temp = this.cards.get(j-1).getNumber();
                    this.cards.get(j-1).setNumber(this.cards.get(j).getNumber());
                    this.cards.get(j).setNumber(temp);
                }
            }
        }
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
}
