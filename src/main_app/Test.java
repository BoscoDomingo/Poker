package main_app;

import java.util.ArrayList;
import java.util.Random;

public class Test {

    public static void main(String[] args) {
       Hand mano = new Hand();
       ArrayList<Card> cartas = new ArrayList<>();
       cartas.add(new Card(5,'H'));
       cartas.add(new Card(4,'H'));
       cartas.add(new Card(2,'C'));
       cartas.add(new Card(5,'H'));
       cartas.add(new Card(5,'H'));
        //System.out.println(Combinations.checkCombinations(cartas));
       mano.setCards(cartas);
        Player player1 = new Player(1, 1000, "pepe");
        player1.setHand(mano);

        Hand mano2 = new Hand();
        ArrayList<Card> cartas2 = new ArrayList<>();
        cartas2.add(new Card(4,'H'));
        cartas2.add(new Card(4,'H'));
        cartas2.add(new Card(3,'C'));
        cartas2.add(new Card(4,'H'));
        cartas2.add(new Card(5,'H'));
        mano2.setCards(cartas2);
        Player player2 = new Player(2, 1000, "pepeas");
        player2.setHand(mano2);

        System.out.print("Player " +player1.getId()+ ": ");
        for(int i=0;i<player1.getHand().getCards().size();i++){
            System.out.print(player1.getHand().getCards().get(i).getNumber());
            System.out.print(player1.getHand().getCards().get(i).getSuit() + " ");
        }
        System.out.print("\nPlayer " +player2.getId()+ ": ");
        for(int i=0;i<player2.getHand().getCards().size();i++){
            System.out.print(player2.getHand().getCards().get(i).getNumber());
            System.out.print(player2.getHand().getCards().get(i).getSuit() + " ");
        }System.out.println();

        player1.getHand().bubbleSort();
        player2.getHand().bubbleSort();

        Player[] players = {player1,player2};

        Table table = new Table();
        ArrayList<Player> bestPlayers = table.checkBestPlayer(players);
        for(int i=0;i<bestPlayers.size();i++){
            System.out.println(bestPlayers.get(i).getId());
        }
       /* Player player1 = new Player(1, 1000, "pepe");
        for (int i = 0; i < hand.length; i++) {
            player1.getHand().getCards().add(hand[i]);
        }
        player1.getHand().printHand();
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
        Random r = new Random();
        for (int i = 0; i < 11; i++) {
            System.out.println((r.nextInt(2)));
        }*/
        // App.run();
    }
}
