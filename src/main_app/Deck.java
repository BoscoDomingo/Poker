package main_app;

import java.util.Random;

public class Deck {
    private Card[] deck = new Card[52];

    public Card getCard(int i) {
        return this.deck[i];
    }

    public void generateDeck() {
        char suit;
        for (int i = 0; i < 52; i++) {
            if (i / 13 == 0) suit = 'P';
            else if (i / 13 == 1) suit = 'C';
            else if (i / 13 == 2) suit = 'R';
            else suit = 'T';
            this.deck[i] = new Card(i % 13 + 1, suit);
        }
    }

    public void sort()
    {
        // If running on Java 6 or older, use `new Random()` on RHS here
        Random rnd = new Random();
        for (int i = this.deck.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            Card a = this.deck[index];
            this.deck[index] = this.deck[i];
            this.deck[i] = a;
        }
    }
}
