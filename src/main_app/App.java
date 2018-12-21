package main_app;

public class App {
    public static void run() {
        Deck deck = new Deck();
        Card card = null;
        deck.generateDeck();
        for (int i = 0; i < 52; i++) {
            card = deck.getCard(i);
            System.out.println(card.getNumber() + " " + card.getSuit());
        }
        //deck.sort();
        for (int i = 0; i < 52; i++) {
            card = deck.getCard(i);
            System.out.println(card.getNumber() + " " + card.getSuit());
        }
    }
}
