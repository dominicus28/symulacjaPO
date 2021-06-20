package Symulacja;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Klasa Plansza
 *
 * Zawiera informacje o:
 * 1. Szerokosci i wysokosci planszy.
 * 2. Liczbie zwierzat i roslin wystepujacych na planszy.
 * 3. Wspołrzednych planszy na ktorych wystepuja obiekty.
 * Umozliwia usuwanie obiektow z planszy gdy zostana zjedzone podczas symulacji lasu.
 */
public class Plansza {
    /**
     * Zmienne klasy Plansza
     */
    Random rand = new Random();
    public int szerokosc;
    public int wysokosc;
    public int liczba_wilkow;
    public int liczba_saren;
    public int liczba_jeleni;
    public int liczba_dzikow;
    public int liczba_traw;
    public int liczba_zoledzi;
    public List<Zwierze> zwierzeta = new ArrayList<>();
    public List<Roslina> rosliny = new ArrayList<>();

    /**
     * Konstruktor klasy Plansza
     *
     * @param x - szerokosc planszy.
     * @param y - wysokosc planszy.
     * @param w - liczba wilkow.
     * @param s - liczba saren.
     * @param j - liczba jeleni.
     * @param d - liczba dzikow.
     * @param t - liczba traw.
     * @param z - liczba zoledzi.
     */
    public Plansza(int x, int y, int w, int s, int j, int d, int t, int z) {
        this.szerokosc = x;
        this.wysokosc = y;
        this.liczba_wilkow = w;
        this.liczba_saren = s;
        this.liczba_jeleni = j;
        this.liczba_dzikow = d;
        this.liczba_traw = t;
        this.liczba_zoledzi = z;
    }

    /**
     * Metoda sprawdz_pole
     *
     * Odpowiada za sprawdzenie pola na planszy - czy znajduje się na nim jakis obiekt klasy Zwierze lub Roslina.
     * @param pozycja_X - wspolrzedna pozioma.
     * @param pozycja_Y - wspolrzedna pionowa.
     * @return - informacja zwrotna jeżeli pole jest puste.
     */
    public String sprawdz_pole(int pozycja_X, int pozycja_Y) {
        for (Zwierze zwierze : zwierzeta) {
            if ((pozycja_X == zwierze.pozycja_X) && (pozycja_Y == zwierze.pozycja_Y) && (zwierze.czy_zyje)) {
                return zwierze.gatunek;
            }
        }
        for (Roslina roslina : rosliny) {
            if ((pozycja_X == roslina.pozycja_X) && (pozycja_Y == roslina.pozycja_Y) && (roslina.czy_rosnie)) {
                return roslina.gatunek;
            }
        }
        return "Puste";
    }

    /**
     * Metoda usun_osobnika
     *
     * Odpowiada za usuwanie obiektow, które napotkaly drapieznika na swoich wspolrzednych.
     * @param pozycja_X - wspolrzedna pozioma.
     * @param pozycja_Y - wspolrzedna pionowa.
     */
    public void usun_osobnika(int pozycja_X, int pozycja_Y) {
        for (Zwierze zwierze : zwierzeta) {
            if ((pozycja_X == zwierze.pozycja_X) && (pozycja_Y == zwierze.pozycja_Y)) {
                zwierze.czy_zyje = false;
                //System.out.println("Usunieto osobnika");
                return;
            }
        }
        for (Roslina roslina : rosliny) {
            if ((pozycja_X == roslina.pozycja_X) && (pozycja_Y == roslina.pozycja_Y)) {
                roslina.czy_rosnie = false;
            }
        }
    }

    /**
     * Metoda przechowywanie_zwierzat
     *
     * Wykorzystywana jest podczas uruchamiania symulacji.
     * Odpowiada za rozmieszczanie ustalonej liczby zwierzat na planszy.
     */
    public void przechowywanie_zwierzat() {

        int l_wilkow = liczba_wilkow;
        int id_wilk = 0;
        while (l_wilkow > 0) {
            int poz_x = rand.nextInt(szerokosc);
            int poz_y = rand.nextInt(wysokosc);
            if (sprawdz_pole(poz_x, poz_y) == "Puste") {
                zwierzeta.add(new Wilk(id_wilk, poz_x, poz_y));
                l_wilkow--;
                id_wilk++;
            }
        }

        int l_saren = liczba_saren;
        int id_sarna = 0;
        while (l_saren > 0) {
            int poz_x = rand.nextInt(szerokosc);
            int poz_y = rand.nextInt(wysokosc);
            if (sprawdz_pole(poz_x, poz_y) == "Puste") {
                zwierzeta.add(new Sarna(id_sarna, poz_x, poz_y));
                l_saren--;
                id_sarna++;
            }
        }

        int l_jeleni = liczba_jeleni;
        int id_jelen = 0;
        while (l_jeleni > 0) {
            int poz_x = rand.nextInt(szerokosc);
            int poz_y = rand.nextInt(wysokosc);
            if (sprawdz_pole(poz_x, poz_y) == "Puste") {
                zwierzeta.add(new Jelen(id_jelen, poz_x, poz_y));
                l_jeleni--;
                id_jelen++;
            }
        }

        int l_dzikow = liczba_dzikow;
        int id_dzik = 0;
        while (l_dzikow > 0) {
            int poz_x = rand.nextInt(szerokosc);
            int poz_y = rand.nextInt(wysokosc);
            if (sprawdz_pole(poz_x, poz_y) == "Puste") {
                zwierzeta.add(new Dzik(id_dzik, poz_x, poz_y));
                l_dzikow--;
                id_dzik++;
            }
        }
        System.out.println("Liczba dodanych zwierzat: " + zwierzeta.size());
    }
    /**
     * Metoda przechowywanie_roslin
     *
     * Wykorzystywana jest podczas uruchamiania symulacji.
     * Odpowiada za rozmieszczanie ustalonej liczby roslin na planszy.
     */
    public void przechowywanie_roslin() {
        int l_traw = liczba_traw;
        int id_trawa = 0;
        while (l_traw > 0) {
            int poz_x = rand.nextInt(szerokosc);
            int poz_y = rand.nextInt(wysokosc);
            if (sprawdz_pole(poz_x, poz_y) == "Puste") {
                rosliny.add(new Trawa(id_trawa, poz_x, poz_y));
                l_traw--;
                id_trawa++;
            }
        }

        int l_zoledzi = liczba_zoledzi;
        int id_zoladz = 0;
        while (l_zoledzi > 0) {
            int poz_x = rand.nextInt(szerokosc);
            int poz_y = rand.nextInt(wysokosc);
            if (sprawdz_pole(poz_x, poz_y) == "Puste") {
                rosliny.add(new Zoladz(id_zoladz, poz_x, poz_y));
                l_zoledzi--;
                id_zoladz++;
            }
        }
        System.out.println("Liczba dodanych roslin: " + rosliny.size());
    }
}


