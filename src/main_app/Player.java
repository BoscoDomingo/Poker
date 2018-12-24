package main_app;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    Hand hand;
    int id;
    int balance;
    String name;

    public boolean isBroke() {
        return balance <= 0;
    }

    public ArrayList<Card> drawFromDeck(ArrayList<Card> cardsFromDeck) {
        ArrayList<Card> cardsToReturnToDeck = selectCardsToDiscard();
        for (Card removed : cardsToReturnToDeck) {
            this.hand.getCards().remove(removed);
        }
        for (Card added : cardsFromDeck){
            this.hand.getCards().add(added);
        }
        return cardsToReturnToDeck;
    }

    private void printDiscardWelcome() {
        System.out.println("Please choose the cards you want to discard by inputting the index of the card (1st card will be 0, 2nd will be 1, etc.) separated by commas (eg. 0,3 will discard 1st and 4th cards):");
        System.out.println("(Note: If you wish to cancel, input any letter)");
    }

    private boolean cancelDiscard() {
        System.out.println("Cancel discard? (Y/N)");

        Scanner scan = new Scanner(System.in);
        String selector = scan.nextLine().toLowerCase();

        if (selector == "y" || selector == "yes") {
            return true;
        } else if (selector == "n" || selector == "no") {
            return false;
        } else {
            System.out.println("Sorry, not a valid answer. Try again:");
            return cancelDiscard();
        }
    }

    private boolean confirmDiscard() {
        Scanner scan = new Scanner(System.in);
        String selector = scan.next().toLowerCase();
        boolean confirmation = true;

        if (selector == "n" || selector == "no") {
            confirmation = false;
        } else if (selector != "yes" || selector != "y") {
            System.out.println("Not a valid answer. Try again: ");
            confirmation = confirmDiscard();
        }
        return confirmation;
    }

    private ArrayList<Card> selectCardsToDiscard() {
        ArrayList<Card> chosenCards = new ArrayList<Card>();
        printDiscardWelcome();
        Scanner scan = new Scanner(System.in);

        while (!scan.hasNextLine()) {
            System.out.println("Please, type an answer.");
        }

        if (!scan.hasNextInt()) {
            if (cancelDiscard()) {
                return null;
            }
        }

        while (scan.hasNextInt()) {
            int i = scan.nextInt();
            if (i > this.hand.getCards().size() - 1) {
                System.out.println(i + "is not a valid index. Must be between 0 and 4. Please try again.");
                chosenCards.clear();
                chosenCards = selectCardsToDiscard();
            } else {
                chosenCards.add(this.hand.getCards().get(i));
            }
        }

        System.out.println("Are you sure you want to discard: ");
        for (Card c : chosenCards) {
            if (chosenCards.indexOf(c) != chosenCards.size() - 1)
                System.out.println(c.getNumber() + c.getSuit() + ", ");
            else System.out.println(c.getNumber() + c.getSuit() + "? (Y/N)");
        }

        if (!confirmDiscard()) {
            chosenCards.clear();
            chosenCards = selectCardsToDiscard();
        }
        return chosenCards;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
