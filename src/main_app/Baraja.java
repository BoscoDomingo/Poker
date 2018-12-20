package main_app;

public class Baraja {
    private Carta[] baraja = new Carta[52];

    public Carta getCarta(int i) {
        return this.baraja[i];
    }

    public void generarBaraja() {
        char palo;
        for (int i = 1; i < 5; i++) {
            if (i == 1) palo = 'P';
            else if (i == 2) palo = 'C';
            else if (i == 3) palo = 'R';
            else palo = 'T';
            for (int j = 1; j < 14; j++) {
                this.baraja[i * j + j-1] = new Carta(i * j + j, palo);
            }
        }
    }
}
