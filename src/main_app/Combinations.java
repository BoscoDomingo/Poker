package main_app;

import java.util.ArrayList;

public class Combinations {

    public static int checkCombinations(Hand hand) {
        ArrayList<Card> aux = new ArrayList<Card>(hand.getCards());
        int combination = 1;
        if (checkRoyalFlush(aux)) combination = 10;
        else if (checkStraightFlush(aux)) combination = 9;
        else if (checkFourOfAKind(aux)) combination = 8;
        else if (checkFullHouse(aux)) combination = 7;
        else if (checkFlush(aux)) combination = 6;
        else if (checkStraight(aux)) combination = 5;
        else if (checkThreeOfAKind(aux)) combination = 4;
        else if (checkTwoPairs(aux)) combination = 3;
        else if (checkPair(aux)) combination = 2;
        return combination;
    }

    public static void printCombination(int combination){
        switch(combination){
            case(2):
                System.out.println("Pair");
                break;
            case(3):
                System.out.println("Two Pairs");
                break;
            case(4):
                System.out.println("Three Of A Kind");
                break;
            case(5):
                System.out.println("Straight");
                break;
            case(6):
                System.out.println("Flush");
                break;
            case(7):
                System.out.println("Full House");
                break;
            case(8):
                System.out.println("Four Of A Kind");
                break;
            case(9):
                System.out.println("Straight Flush");
                break;
            case(10):
                System.out.println("Royal Flush");
                break;
            default:
                System.out.println("High Card");
                break;
        }
    }

    private static boolean checkPair(ArrayList<Card> hand) {
        boolean found = false;
        for (int i = 0; i < hand.size() - 1; i++) {
            if (hand.get(i).getNumber() == hand.get(i+1).getNumber()) found = true;
        }
        return found;
    }

    private static boolean checkTwoPairs(ArrayList<Card> hand) {
        int numFound = 0;
        for (int i = 0; i < hand.size() - 1; i++) {
            if (hand.get(i).getNumber() == hand.get(i+1).getNumber()) numFound++;
        }
        return numFound == 2;
    }

    private static boolean checkThreeOfAKind(ArrayList<Card> hand) {
        boolean found = false;
        for (int i = 0; i < hand.size() - 2; i++) {
            if (hand.get(i).getNumber() == hand.get(i+1).getNumber() && hand.get(i).getNumber() == hand.get(i+2).getNumber())
                found = true;
        }
        return found;
    }

    private static boolean checkStraight(ArrayList<Card> hand) {
        int found = 0;
        for (int i = 0; i < hand.size() - 1; i++) {
            if ((hand.get(i+1).getNumber() - hand.get(i).getNumber()) == 1 || (hand.get(i+1).getNumber() - hand.get(i).getNumber()) == 9)
                found++;
        }
        return found == 4;
    }

    private static boolean checkFlush(ArrayList<Card> hand) {
        boolean found = true;
        for (int i = 0; i < hand.size() - 1; i++) {
            if (hand.get(i).getSuit() != hand.get(i+1).getSuit()) found = false;
        }
        return found;
    }

    private static boolean checkFullHouse(ArrayList<Card> hand) {
        boolean found = false;
        if (hand.get(0).getNumber() == hand.get(1).getNumber() && hand.get(1).getNumber() == hand.get(2).getNumber()) {
            if (hand.get(3).getNumber() == hand.get(4).getNumber()) found = true;
        } else if (hand.get(0).getNumber() == hand.get(1).getNumber()) {
            if (hand.get(2).getNumber() == hand.get(3).getNumber() && hand.get(3).getNumber() == hand.get(4).getNumber()) found = true;
        }
        return found;
    }

    private static boolean checkFourOfAKind(ArrayList<Card> hand) {
        boolean found = false;
        int i = 0, equalCards = 1;
        while (equalCards < 4 && i < hand.size() - 1) {
            if (hand.get(i).getNumber() == hand.get(i+1).getNumber()) {
                equalCards++;
            } else equalCards = 1;
            i++;
        }
        return equalCards >= 4;
    }

    private static boolean checkStraightFlush(ArrayList<Card> hand) {
        int found = 0;
        boolean flush = true;
        for (int i = 0; i < hand.size() - 1; i++) {
            if (hand.get(i).getSuit() != hand.get(i+1).getSuit()) flush = false;
            if ((hand.get(i+1).getNumber() - hand.get(i).getNumber()) == 1 || (hand.get(i+1).getNumber() - hand.get(i).getNumber()) == 9)
                found++;
        }
        return (found == 4 && flush);
    }

    private static boolean checkRoyalFlush(ArrayList<Card> hand) {
        return (checkStraightFlush(hand) && hand.get(0).getNumber() == 1 && hand.get(1).getNumber() == 10);
    }
}

