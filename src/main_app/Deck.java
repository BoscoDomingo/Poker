package main_app;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Card> deck;

    public void generateDeck() {
        char suit;
        for (int i = 0; i < 52; i++) {
            if (i / 13 == 0) suit = 'S';
            else if (i / 13 == 1) suit = 'H';
            else if (i / 13 == 2) suit = 'D';
            else suit = 'C';
            this.deck.add(new Card(i % 13 + 1, suit));
        }
    }

    public void shuffle() {
        Random rnd = new Random();
        for (int i = this.deck.size() - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            Card a = this.getCard(index);
            this.deck.set(index, this.getCard(i));
            this.deck.set(i, a);
        }
    }

    public ArrayList<Card> pickXCards(int number) {
        ArrayList<Card> picked = new ArrayList<>();
        Random r = new Random();
        for (int i = 1; i <= number; i++) {
            picked.add(getCard(r.nextInt(deck.size()))); //deck size changes. Upper bound should reflect that
        }
        return picked;
    }

    public void returnCardsToDeck(ArrayList<Card> cardsToBeReturned) {
        for (Card card : cardsToBeReturned) {
            this.deck.add(0, card);
        }
    }

    public Card getCard(int i) {
        return deck.get(i);
    }

    //DELETE?
   /* public Card getTopCard() {
        return deck.get(deck.size() - 1);
    }

    public void addCardsToDeck(ArrayList<Card> cardsToAdd) {
        for (Card card : cardsToAdd) {
            this.deck.add(card);
        }
    }*/

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public int getIndex(Card card) {
        return deck.indexOf(card);
    }
}
