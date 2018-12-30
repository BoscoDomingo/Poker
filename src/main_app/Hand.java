package main_app;

import java.util.ArrayList;

public class Hand {
    ArrayList<Card> cards;/*should've been an array to ensure there's 5 cards at all times,
    but can be achieved through careful coding. Was left an ArrayList
    for scalability purposes too (eg implementing different game modes)*/

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
            else System.out.println(c.getNumber() + "" + c.getSuit() + "\n");
        }
    }

    public void bubbleSort() {
        Card temp;
        for (int i = 0; i < this.cards.size(); i++) {
            for (int j = 1; j < (this.cards.size() - i); j++) {
                if (this.cards.get(j-1).getNumber() > this.cards.get(j).getNumber()) {
                    temp = this.cards.get(j-1);
                    this.cards.set(j-1,this.cards.get(j));
                    this.cards.set(j,temp);
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
