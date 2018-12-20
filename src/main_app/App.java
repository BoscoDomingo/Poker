package main_app;

public class App {
    public static void run() {
        Baraja baraja = new Baraja();
        Carta carta = null;
        baraja.generarBaraja();
        carta = baraja.getCarta(4);
        System.out.println(carta.getNumero() + " " + carta.getPalo());
    }
}
