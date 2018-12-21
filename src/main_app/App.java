package main_app;

public class App {
    public static void run() {
        Deck deck = new Deck();
        Card card = null;
        deck.generarBaraja();
        for (int i = 0; i < 52; i++) {
            card = deck.getCarta(i);
            System.out.println(card.getNumero() + " " + card.getPalo());
        }
        deck.barajear();
        for (int i = 0; i < 52; i++) {
            card = deck.getCarta(i);
            System.out.println(card.getNumero() + " " + card.getPalo());
        }
    }
}
