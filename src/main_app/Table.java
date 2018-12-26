package main_app;

import main_app.rounds.DrawingRound;
import main_app.rounds.Round;

import java.util.ArrayList;

public class Table {
    private Player[] players = new Player[2];
    private Round round;

    public void startRound(Deck deck){
       // this.round = new DrawingRound();
        round.start(players, deck);
    }

    public ArrayList<Player> checkBestPlayer(Player[] players){
        int best=0,combination=0;
        ArrayList<Player> bestPlayers = new ArrayList<>();
        for(int i=0;i<players.length;i++){
            combination=Combinations.checkCombinations(players[i].getHand().getCards());
            if(combination>best){
                bestPlayers.clear();
                bestPlayers.add(players[i]);
                best=combination;
            }else if(combination==best){
                bestPlayers.add(players[i]);
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
