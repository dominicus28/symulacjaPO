package Symulacja;

/**
 * Klasa potomna - Zoladz
 *
 * Dziedziczy po klasie Roslina.
 * Zawiera informacje o identyfikatorze obiektów Zoladz, współrzędnych na planszy oraz statusie czy_rosnie.
 */
public class Zoladz extends Roslina {
    /**
     * Konstruktor klasy Zoladz
     * @param id - identyfikator obiektu Zoladz.
     * @param x - wspolrzedna pozioma.
     * @param y - wspolrzedna pionowa.
     */
    public Zoladz(int id, int x, int y) {
        this.numer_id=id;
        this.gatunek="Zoladz";
        this.pozycja_X= x;
        this.pozycja_Y= y;
        czy_rosnie=true;

    }

    /**
     * Metoda pozyw
     */
    public void pozyw(Plansza plansza){

    }
}
