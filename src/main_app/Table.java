package main_app;

import main_app.rounds.DrawingRound;
import main_app.rounds.Round;

import java.util.ArrayList;

public class Table {
    private Player[] players = new Player[2];
    private Round round;

    public void startRound(Deck deck) {
        // this.round = new DrawingRound();
        round.start(players, deck);
    }

    public ArrayList<Player> checkBestPlayer(Player[] players) {
        int best = 0, combination = 0;
        ArrayList<Player> bestPlayers = new ArrayList<>();
        for (int i = 0; i < players.length; i++) {
            combination = Combinations.checkCombinations(players[i].getHand().getCards());
            if (combination > best) {
                bestPlayers.clear();
                bestPlayers.add(players[i]);
                best = combination;
            } else if (combination == best) {
                bestPlayers.add(players[i]);
            }
        }
        //Checks highest card in case of draw
        int highestCard=0;
        if (best == 1) {
            for (int j = 0; j < players.length; j++) {
                 if(players[j].getHand().getCards().get(0).getNumber()==1){
                     if(highestCard==1){
                         bestPlayers.add(players[j]);
                     }else {
                         bestPlayers.clear();
                         bestPlayers.add(players[j]);
                         highestCard=1;
                     }
                 }else if(players[j].getHand().getCards().get(4).getNumber()>highestCard && highestCard!=1){
                     bestPlayers.clear();
                     bestPlayers.add(players[j]);
                     highestCard=players[j].getHand().getCards().get(4).getNumber();
                 }else if(players[j].getHand().getCards().get(4).getNumber()==highestCard){
                     bestPlayers.add(players[j]);
                 }
            }
        }
        return bestPlayers;
}

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }
}
