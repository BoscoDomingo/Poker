package main_app;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    Hand hand;
    int id;
    int balance;
    String name;

    public Player(int id, int balance, String name) {
        this.hand = new Hand();
        this.id = id;
        this.balance = balance;
        this.name = name;
    }

    public boolean isBroke() {
        return balance <= 0;
    }

    public ArrayList<Card> drawFromDeck(ArrayList<Card> cardsFromDeck) {
        ArrayList<Card> cardsToReturnToDeck = selectCardsToDiscard(cardsFromDeck.size());

        for (Card removed : cardsToReturnToDeck) {
            this.hand.getCards().remove(removed);
        }
        for (Card added : cardsFromDeck) {
            this.hand.getCards().add(added);
        }
        return cardsToReturnToDeck;
    }

    private ArrayList<Card> selectCardsToDiscard(int numberOfCardsToDiscard) {
        ArrayList<Card> chosenCards = new ArrayList<Card>();
        printDiscardWelcome(numberOfCardsToDiscard);
        Scanner scan = new Scanner(System.in);
        boolean done = false;
        while (!done) {

            if (!scan.hasNextInt()) {
                if (cancelDiscard()) {
                    return null;
                } else {
                    System.out.println("Please, choose the " + numberOfCardsToDiscard + " cards you want to discard");
                    scan.next();
                }
            }

            prepareDiscard(chosenCards, scan, numberOfCardsToDiscard);

            printConfirmDiscard(chosenCards);

            if (!confirmDiscard()) {
                chosenCards.clear();
            } else done = true;
        }
        return chosenCards;
    }

    private void printDiscardWelcome(int numberOfCardsToDiscard) {
        System.out.println("\nPlease choose the " + numberOfCardsToDiscard + " card(s) you want to discard by inputting the index of the card (1st card will be 0, 2nd will be 1, etc.) separated by spaces and press Enter\n(eg. 0 3 will discard 1st and 4th cards):");
        System.out.println("When done choosing, just enter any character and press Enter");
        System.out.println("(Note: If you wish to cancel, input any letter)");
    }

    private void printConfirmDiscard(ArrayList<Card> chosenCards) {
        System.out.println("Are you sure you want to discard the following cards: ");
        for (Card c : chosenCards) {
            if (chosenCards.indexOf(c) != chosenCards.size() - 1)
                System.out.print(c.getNumber() + "" + c.getSuit() + ", ");
            else System.out.println(c.getNumber() + "" + c.getSuit() + "? (Y/N)");
        }
    }

    private boolean cancelDiscard() {
        System.out.println("Cancel discard? (Y/N)");

        Scanner scan = new Scanner(System.in);
        String selector = scan.next();

        if (selector.equalsIgnoreCase("y") || selector.equalsIgnoreCase("yes")) {
            return true;
        } else if (selector.equalsIgnoreCase("n") || selector.equalsIgnoreCase("no")) {
            return false;
        } else {
            System.out.println("Sorry, not a valid answer. Try again:");
            return cancelDiscard();
        }
    }

    private void prepareDiscard(ArrayList<Card> chosenCards, Scanner scan, int numberOfCardsToDiscard) {
        boolean done = false;
        while (!done) {
            while (scan.hasNextInt()) {
                int i = scan.nextInt();
                if (i > this.hand.getCards().size() - 1) {
                    System.out.println(i + " is not a valid index. Must be between 0 and 4. Please try again.");
                    chosenCards.clear();
                    scan.reset();
                } else {
                    chosenCards.add(this.hand.getCards().get(i));
                }
            }
            if (chosenCards.size() != numberOfCardsToDiscard) {
                if (chosenCards.size() > numberOfCardsToDiscard) {
                    System.out.println("You picked too many cards. Try again");
                } else if (chosenCards.size() > 1 && chosenCards.size() < numberOfCardsToDiscard) {
                    System.out.println("You didn't pick enough cards. Try again");
                }
                chosenCards.clear();
                scan.next();
                //prepareDiscard(chosenCards, scan, numberOfCardsToDiscard);
            } else {
                done = true;
            }
        }
    }

    private boolean confirmDiscard() {
        Scanner scan = new Scanner(System.in);
        String selector = scan.next().toLowerCase();
        boolean confirmation = true;

        if (selector.equalsIgnoreCase("n") || selector.equalsIgnoreCase("no")) {
            confirmation = false;
        } else if (!selector.equalsIgnoreCase("y") && !selector.equalsIgnoreCase("yes")) {
            System.out.println("Not a valid answer. Try again: ");
            confirmation = confirmDiscard();
        }
        return confirmation;
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
