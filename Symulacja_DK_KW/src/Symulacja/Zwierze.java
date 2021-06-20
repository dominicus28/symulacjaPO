package Symulacja;

/**
 * Klasa abstrakcyjna Zwierze
 *
 * Zapewnia klasom dziedziczonym korzystanie z metody poruszanie.
 * Zawiera zmienne informujące o gatunku zwierzat, wspolrzednych na planszy oraz okreslaja czy dany obiekt nadal zyje.
 * Klasa rodzica klas:
 * Wilk
 * Dzik
 * Jelen
 * Sarna
 */
public abstract class Zwierze {
    /**
     * Zmienne klasy Zwierze
     */
    public int numer_id;
    public String gatunek;
    public int pozycja_X;
    public int pozycja_Y;
    public boolean czy_zyje;

    /**
     * Metoda poruszanie
     */
    abstract public void poruszanie(Plansza plansza);

}
