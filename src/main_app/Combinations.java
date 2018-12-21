package main_app;

public class Combinations {

    void bubbleSort(Card[] arr) {
        int n = arr.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1].getNumber() > arr[j].getNumber()) {
                    temp = arr[j - 1].getNumber();
                    arr[j - 1].setNumber(arr[j].getNumber());
                    arr[j].setNumber(temp);
                }
            }
        }
    }

    public int checkCombinations(Card[] hand) {
        Card[] aux = hand;
        bubbleSort(aux);
        for (int i = 0; i < aux.length; i++) {
            System.out.print(aux[i].getNumber()+ "" + aux[i].getSuit() + " ");
        }
        System.out.println();
        int combination = 1;
        if(checkRoyalFlush(aux))combination = 10;
        else if (checkStraightFlush(aux)) combination = 9;
        else if (checkFourOfAKind(aux)) combination = 8;
        else if (checkFullHouse(aux)) combination = 7;
        else if (checkFlush(aux)) combination = 6;
        else if (checkStraight(aux)) combination = 5;
        else if (checkThreeOfAKind(aux)) combination = 4;
        else if (checkTwoPairs(hand)) combination = 3;
        else if (checkPair(aux)) combination = 2;
        return combination;
    }

    private boolean checkPair(Card[] hand) {
        boolean found = false;
        for (int i = 0; i < hand.length - 1; i++) {
            if (hand[i].getNumber() == hand[i + 1].getNumber()) found = true;
        }
        return found;
    }

    private boolean checkTwoPairs(Card[] hand) {
        int numFound = 0;
        for (int i = 0; i < hand.length - 1; i++) {
            if (hand[i].getNumber() == hand[i + 1].getNumber()) numFound++;
        }
        return numFound == 2;
    }

    private boolean checkThreeOfAKind(Card[] hand) {
        boolean found = false;

        for (int i = 0; i < hand.length - 2; i++) {
            if (hand[i].getNumber() == hand[i + 1].getNumber() && hand[i].getNumber() == hand[i + 2].getNumber())
                found = true;
        }
        return found;
    }

    private boolean checkStraight(Card[] hand) {
        int found = 0;
        for (int i = 0; i < hand.length - 1; i++) {
            if ((hand[i + 1].getNumber() - hand[i].getNumber()) == 1 || (hand[i + 1].getNumber() - hand[i].getNumber()) == 9)
                found++;
        }
        return found == 4;
    }

    private boolean checkFlush(Card[] hand) {
        boolean found = true;
        for (int i = 0; i < hand.length - 1; i++) {
            if (hand[i].getSuit() != hand[i + 1].getSuit()) found = false;
        }
        return found;
    }

    private boolean checkFullHouse(Card[] hand) {
        boolean found = false;
        if (hand[0].getNumber() == hand[1].getNumber() && hand[1].getNumber() == hand[2].getNumber()) {
            if (hand[3].getNumber() == hand[4].getNumber()) found = true;
        } else if (hand[0].getNumber() == hand[1].getNumber()) {
            if (hand[2].getNumber() == hand[3].getNumber() && hand[3].getNumber() == hand[4].getNumber()) found = true;
        }
        return found;
    }

    private boolean checkFourOfAKind(Card[] hand) {
        return (hand[0].getNumber() == hand[1].getNumber() && hand[1].getNumber() == hand[2].getNumber() && hand[2].getNumber() == hand[3].getNumber() ||
                hand[4].getNumber() == hand[1].getNumber() && hand[1].getNumber() == hand[2].getNumber() && hand[2].getNumber() == hand[3].getNumber());
    }

    private boolean checkStraightFlush(Card[] hand) {
        int found = 0;
        boolean flush = true;
        for (int i = 0; i < hand.length - 1; i++) {
            if (hand[i].getSuit() != hand[i + 1].getSuit()) flush = false;
            if ((hand[i + 1].getNumber() - hand[i].getNumber()) == 1 || (hand[i + 1].getNumber() - hand[i].getNumber()) == 9)
                found++;
        }
        return (found == 4 && flush);
    }

    private boolean checkRoyalFlush(Card[] hand){
        return (checkStraightFlush(hand) && hand[0].getNumber() == 1 && hand[1].getNumber() == 10);
    }
}

