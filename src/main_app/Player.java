package main_app;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private Hand hand;
    private int id;
    private int balance;
    private String name;

    public Player(int id, int balance, String name) {
        this.hand = new Hand();
        this.id = id;
        this.balance = balance;
        this.name = name;
    }

    //General
    public boolean isBroke() {
        return balance <= 0;
    }

    public void generateHand(Deck deck) {
        ArrayList<Card> cardsToFormHand = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            cardsToFormHand.add(deck.getTopCard());
        }
        this.hand.setCards(cardsToFormHand);
        this.hand.bubbleSort();
    }

    //Drawing Round
    public int askForXCards() {
        System.out.println("Choose how many cards you want to discard (number between 0-5)");
        Scanner scan = new Scanner(System.in);
        while (!scan.hasNextInt()) {
            System.out.println("Please enter a number");
            scan.next();
        }
        int number = scan.nextInt();
        while (number < 0 || number > 5) {
            System.out.println("Please enter a valid answer(number between 0-5)");
            while (!scan.hasNextInt()) {
                System.out.println("Please enter a number");
                scan.next();
            }
            number = scan.nextInt();
        }
        return number;
    }

    public boolean askIfStillPlaying() {
        System.out.println("Do you want to keep playing this turn? (Y/N)");
        Scanner scan = new Scanner(System.in);
        String selector = scan.nextLine();
        while (!(selector.equalsIgnoreCase("yes") || selector.equalsIgnoreCase("y") || selector.equalsIgnoreCase("no") || selector.equalsIgnoreCase("n"))) {
            System.out.println("Please enter a valid answer");
            selector = scan.nextLine();
        }
        return (selector.equalsIgnoreCase("y") || selector.equalsIgnoreCase("yes"));
    }

    public ArrayList<Card> drawFromDeck(ArrayList<Card> cardsFromDeck) {
        ArrayList<Card> cardsToReturnToDeck = selectCardsToDiscard(cardsFromDeck.size());
        if (cardsToReturnToDeck != null) {
            for (Card removed : cardsToReturnToDeck) {
                this.hand.getCards().remove(removed);
            }
            for (Card added : cardsFromDeck) {
                this.hand.getCards().add(added);
            }
            this.hand.bubbleSort();
            return cardsToReturnToDeck;
        } else {
            return cardsFromDeck;
        }
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
        if (chosenCards.size() == 0) {
            return null;
        }
        return chosenCards;
    }

    private void printDiscardWelcome(int numberOfCardsToDiscard) {
        System.out.println("\nPlease choose the " + numberOfCardsToDiscard + " card(s) you want to discard separated by spaces and press Enter\n(eg. '1 3 .' will discard 1st and 3rd cards):");
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
                int i = scan.nextInt() - 1;
                if (i > this.hand.getCards().size() - 1) {
                    System.out.println(i + " is not a valid index. Must be between 1 and 5. Please try again.");
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

    //Betting Round
    public int[] bettingAction(int minimumBet) {
        System.out.println("Choose your next action: \n\t0-Bet the minimum possible amount (" + minimumBet + ")\n\t1-Raise the bet\n\t2-Withdraw this round");
        Scanner scan = new Scanner(System.in);
        while (!scan.hasNextInt()) {
            System.out.println("Please enter a number");
            scan.next();
        }

        int[] number = new int[2];
        number[0] = scan.nextInt();

        while (number[0] < 0 || number[0] > 2) {
            System.out.println("Please enter a valid answer(number between 0-2)");
            while (!scan.hasNextInt()) {
                System.out.println("Please enter a number");
                scan.next();
            }
            number[0] = scan.nextInt();
        }

        if (number[0] == 1) {
            number[1] = raiseBet(minimumBet);
        }

        return number;
    }

    private int raiseBet(int minimumBet) {
        System.out.println("How much do you want to bet?");
        Scanner scan = new Scanner(System.in);
        while (!scan.hasNextInt()) {
            System.out.println("Please enter a number");
            scan.next();
        }
        int number = scan.nextInt();
        while (number < minimumBet || number > this.getBalance()) {
            System.out.println("Please enter a valid answer(number between " + minimumBet + "- + this.getBalance() + ");
            while (!scan.hasNextInt()) {
                System.out.println("Please enter a number");
                scan.next();
            }
            number = scan.nextInt();
        }
        return number;
    }

    //Getters & Setters
    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
