package main_app;

public class Test {

    public static void main(String[] args) {
        Combinations comb = new Combinations();
        Card[] hand = {new Card(10, 'H'), new Card(1, 'H'), new Card(11, 'C'), new Card(12, 'S'), new Card(13, 'D')};
        System.out.println(comb.checkCombinations(hand));
        Card[] hand2 = {new Card(5, 'H'), new Card(1, 'H'), new Card(11, 'H'), new Card(12, 'H'), new Card(13, 'H')};
        System.out.println(comb.checkCombinations(hand2));
        Card[] hand3 = {new Card(10, 'H'), new Card(10, 'H'), new Card(10, 'H'), new Card(12, 'H'), new Card(10, 'H')};
        System.out.println(comb.checkCombinations(hand3));
        Card[] hand4 = {new Card(10, 'C'), new Card(1, 'H'), new Card(10, 'H'), new Card(12, 'H'), new Card(10, 'H')};
        System.out.println(comb.checkCombinations(hand4));
        Card[] hand5 = {new Card(10, 'H'), new Card(1, 'H'), new Card(11, 'H'), new Card(12, 'H'), new Card(9, 'H')};
        System.out.println(comb.checkCombinations(hand5));
        // App.run();
    }
}
