package main_app;

import java.util.Random;

public class Baraja {
    private Carta[] baraja = new Carta[52];

    public Carta getCarta(int i) {
        return this.baraja[i];
    }

    public void generarBaraja() {
        char palo;
        for (int i = 0; i < 52; i++) {
            if (i / 13 == 0) palo = 'P';
            else if (i / 13 == 1) palo = 'C';
            else if (i / 13 == 2) palo = 'R';
            else palo = 'T';
            this.baraja[i] = new Carta(i % 13 + 1, palo);
        }
    }

    public void barajear()
    {
        // If running on Java 6 or older, use `new Random()` on RHS here
        Random rnd = new Random();
        for (int i = this.baraja.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            Carta a = this.baraja[index];
            this.baraja[index] = this.baraja[i];
            this.baraja[i] = a;
        }
    }
}
