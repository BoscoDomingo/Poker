package main_app;

public class App {
    public static void run() {
        Baraja baraja = new Baraja();
        Carta carta = null;
        baraja.generarBaraja();
        for (int i = 0; i < 52; i++) {
            carta = baraja.getCarta(i);
            System.out.println(carta.getNumero() + " " + carta.getPalo());
        }
        baraja.barajear();
        for (int i = 0; i < 52; i++) {
            carta = baraja.getCarta(i);
            System.out.println(carta.getNumero() + " " + carta.getPalo());
        }
    }
}
