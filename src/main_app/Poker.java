package main_app;

public class Poker {
    private Table table;

    public void startGame(Deck deck) {
        Player[] players = {new Player(0, 1000, "John Smith"), new Player(1, 1000, "Mary Rothschild")};
        table = new Table();
        this.table.setPlayers(players);

        while (gameOver() == -1) {
            table.startRound(deck);
        }
        System.out.println("\n-=Congratulations " + table.getPlayers()[gameOver()].getName() + " for winning! Thanks for playing!=-\n\nPress any button to exit");
    }

    private int gameOver() { //this would have to change for a 3+ player game
        int winner = -1;
        if (table.getPlayers()[0].isBroke()) {
            winner = 1;
        } else if (table.getPlayers()[1].isBroke()) {
            winner = 0;
        }
        return winner;
    }
}
