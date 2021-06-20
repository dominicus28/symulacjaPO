package Symulacja;

/**
 * Klasa abstrakcyjna Roślina
 *
 * Zapewnia klasom dziedziczonym korzystanie z metody pozyw.
 * Zawiera zmienne informujace o gatunku roslin, wspolrzednych na planszy oraz okreslaja czy dany obiekt nadal rosnie.
 * Klasa rodzica klas:
 * Trawa
 * Żołądź
 */
public abstract class Roslina {
    /**
     * Zmienne klasy Roslina
     */
    public int numer_id;
    public String gatunek;
    public int pozycja_X;
    public int pozycja_Y;
    public boolean czy_rosnie;

    /**
     * Metoda pozyw
     */
    abstract public void pozyw(Plansza plansza);
}
