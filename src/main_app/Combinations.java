package main_app;

public class Combinations {

    private static void bubbleSort(Card[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < (arr.length - i); j++) {
                if (arr[j - 1].getNumber() > arr[j].getNumber()) {
                    temp = arr[j - 1].getNumber();
                    arr[j - 1].setNumber(arr[j].getNumber());
                    arr[j].setNumber(temp);
                }
            }
        }
    }
//TODO: Mover de clase
    private static void printHand(Card[] hand) {
        for (int i = 0; i < hand.length; i++) {
            System.out.print(hand[i].getNumber() + "" + hand[i].getSuit() + " ");
        }
        System.out.println();
    }

    public static int checkCombinations(Card[] hand) {
        Card[] aux = hand;
        bubbleSort(aux);
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

    private static boolean checkPair(Card[] hand) {
        boolean found = false;
        for (int i = 0; i < hand.length - 1; i++) {
            if (hand[i].getNumber() == hand[i + 1].getNumber()) found = true;
        }
        return found;
    }

    private static boolean checkTwoPairs(Card[] hand) {
        int numFound = 0;
        for (int i = 0; i < hand.length - 1; i++) {
            if (hand[i].getNumber() == hand[i + 1].getNumber()) numFound++;
        }
        return numFound == 2;
    }

    private static boolean checkThreeOfAKind(Card[] hand) {
        boolean found = false;
        for (int i = 0; i < hand.length - 2; i++) {
            if (hand[i].getNumber() == hand[i + 1].getNumber() && hand[i].getNumber() == hand[i + 2].getNumber())
                found = true;
        }
        return found;
    }

    private static boolean checkStraight(Card[] hand) {
        int found = 0;
        for (int i = 0; i < hand.length - 1; i++) {
            if ((hand[i + 1].getNumber() - hand[i].getNumber()) == 1 || (hand[i + 1].getNumber() - hand[i].getNumber()) == 9)
                found++;
        }
        return found == 4;
    }

    private static boolean checkFlush(Card[] hand) {
        boolean found = true;
        for (int i = 0; i < hand.length - 1; i++) {
            if (hand[i].getSuit() != hand[i + 1].getSuit()) found = false;
        }
        return found;
    }

    private static boolean checkFullHouse(Card[] hand) {
        boolean found = false;
        if (hand[0].getNumber() == hand[1].getNumber() && hand[1].getNumber() == hand[2].getNumber()) {
            if (hand[3].getNumber() == hand[4].getNumber()) found = true;
        } else if (hand[0].getNumber() == hand[1].getNumber()) {
            if (hand[2].getNumber() == hand[3].getNumber() && hand[3].getNumber() == hand[4].getNumber()) found = true;
        }
        return found;
    }

    private static boolean checkFourOfAKind(Card[] hand) {
        boolean found = false;
        int i = 0, equalCards = 1;
        while (equalCards < 4 && i < hand.length - 1) {
            if (hand[i].getNumber() == hand[i + 1].getNumber()) {
                equalCards++;
            } else equalCards = 1;
            i++;
        }
        return equalCards >= 4;
    }

    private static boolean checkStraightFlush(Card[] hand) {
        int found = 0;
        boolean flush = true;
        for (int i = 0; i < hand.length - 1; i++) {
            if (hand[i].getSuit() != hand[i + 1].getSuit()) flush = false;
            if ((hand[i + 1].getNumber() - hand[i].getNumber()) == 1 || (hand[i + 1].getNumber() - hand[i].getNumber()) == 9)
                found++;
        }
        return (found == 4 && flush);
    }

    private static boolean checkRoyalFlush(Card[] hand) {
        return (checkStraightFlush(hand) && hand[0].getNumber() == 1 && hand[1].getNumber() == 10);
    }
}

