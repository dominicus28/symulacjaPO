package Symulacja;

import java.util.Random;

/**
 * Klasa potomna - Sarna
 *
 * Dziedziczy po klasie Zwierze.
 * Zawiera informacje o identyfikatorze obiektow Sarna, wspolrzednych na planszy oraz statusie czy_zyje.
 * Posiada metody odpowiedzialne za poruszanie podczas symulacji.
 */
public class Sarna extends Zwierze {
    /**
     * Konstruktor klasy Sarna
     * @param id - identyfikator obiektu Sarna.
     * @param x - wspolrzedna pozioma.
     * @param y - wspolrzedna pionowa.
     */
    public Sarna(int id, int x, int y) {
        this.numer_id = id;
        this.gatunek = "Sarna";
        this.pozycja_X = x;
        this.pozycja_Y = y;
        czy_zyje = true;

    }
    /**
     * Metoda ruch_w_kierunku
     *
     * Odpowiada za wskazanie wspolrzednych do których uda się Sarna podczas następnej iteracji.
     * Wywołuje metode usun_osobnika gdy napotka obiekt typu Trawa.
     * @param nowy_pozX - nowa wspolrzedna pozioma.
     * @param nowy_pozY - nowa wspolrzedna pionowa.
     * @param plansza - informacja o obiekcie Plansza.
     */
    private void ruch_w_kierunku(int nowy_pozX, int nowy_pozY, Plansza plansza) {
        String pole = plansza.sprawdz_pole(nowy_pozX, nowy_pozY);
        switch (pole) {
            case "Puste": {
                pozycja_X = nowy_pozX;
                pozycja_Y = nowy_pozY;
                break;
            }
            case "Trawa": {
                plansza.usun_osobnika(nowy_pozX, nowy_pozY);
                pozycja_X = nowy_pozX;
                pozycja_Y = nowy_pozY;
                break;
            }
            case "Jelen":
            case "Sarna":
            case "Wilk":
            case "Dzik":
                break;
        }
    }
    /**
     * Metoda poruszanie
     *
     * Określa sposob w jaki porusza sie Sarna.
     * Sarna może poruszać sie o 1 pole.
     * @param plansza - informacja o obiekcie Plansza.
     */
    public void poruszanie(Plansza plansza) {
        Random genetor_ruchu = new Random();

        int ruch = genetor_ruchu.nextInt(4);
        switch (ruch) {
            case 0: {//W LEWO
                if ((pozycja_X - 1) >= 0) {
                    ruch_w_kierunku(pozycja_X - 1, pozycja_Y, plansza);
                }
            }
            case 1: {//W PRAWO
                if ((pozycja_X + 1) <= plansza.szerokosc) {
                    ruch_w_kierunku(pozycja_X + 1, pozycja_Y, plansza);
                }

            }
            case 2: {//W GÓRE
                if ((pozycja_Y + 1) <= plansza.szerokosc) {
                    ruch_w_kierunku(pozycja_X, pozycja_Y + 1, plansza);
                }

            }
            case 3: {//W DÓL
                if ((pozycja_Y - 1) >= 0) {
                    ruch_w_kierunku(pozycja_X, pozycja_Y - 1, plansza);
                }

            }
        }

    }
}
