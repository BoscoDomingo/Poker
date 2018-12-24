package main_app;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        Card[] hand = {new Card(10, 'H'), new Card(1, 'S'), new Card(11, 'C'), new Card(12, 'S'), new Card(13, 'D')};
       /* System.out.println(Combinations.checkCombinations(hand));
        Card[] hand2 = {new Card(5, 'H'), new Card(1, 'H'), new Card(11, 'H'), new Card(12, 'H'), new Card(13, 'H')};
        System.out.println(Combinations.checkCombinations(hand2));
        Card[] hand3 = {new Card(10, 'H'), new Card(10, 'H'), new Card(10, 'H'), new Card(12, 'H'), new Card(10, 'H')};
        System.out.println(Combinations.checkCombinations(hand3));
        Card[] hand4 = {new Card(10, 'C'), new Card(1, 'H'), new Card(10, 'H'), new Card(12, 'H'), new Card(10, 'H')};
        System.out.println(Combinations.checkCombinations(hand4));
        Card[] hand5 = {new Card(10, 'H'), new Card(1, 'H'), new Card(11, 'H'), new Card(12, 'H'), new Card(9, 'H')};
        System.out.println(Combinations.checkCombinations(hand5));*/
        Player player1 = new Player(1, 1000, "pepe");
        for (int i = 0; i < hand.length; i++) {
            player1.getHand().getCards().add(hand[i]);
        }
        player1.hand.printHand();
        ArrayList<Card> cards1 = new ArrayList<>();
        ArrayList<Card> cards2 = new ArrayList<>();

        cards1.add(new Card(3, 'C'));
        cards1.add(new Card(2, 'D'));
        // cards1.add(new Card(5, 'D'));
        Hand hand2 = new Hand();
        cards2 = player1.drawFromDeck(cards1);
        hand2.setCards(cards2);
        hand2.printHand();
        player1.getHand().printHand();
        // App.run();
    }
}
