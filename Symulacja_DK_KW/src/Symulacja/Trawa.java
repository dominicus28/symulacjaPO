package Symulacja;

/**
 * Klasa potomna - Trawa
 *
 * Dziedziczy po klasie Roslina.
 * Zawiera informacje o identyfikatorze obiektow Trawa, wspolrzednych na planszy oraz statusie czy_rosnie.
 */
public class Trawa extends Roslina {
    /**
     * Konstruktor klasy Trawa
     * @param id - identyfikator obiektu Trawa.
     * @param x - wspolrzedna pozioma.
     * @param y - wspolrzedna pionowa.
     */
    public Trawa(int id, int x, int y) {
        /**
         * Zmienne klasy Trawa.
         */
        this.numer_id=id;
        this.gatunek="Trawa";
        this.pozycja_X= x;
        this.pozycja_Y= y;
        czy_rosnie=true;
/**
 * Metoda pozyw
 */
    }
    public void pozyw(Plansza plansza) {

    }
}
