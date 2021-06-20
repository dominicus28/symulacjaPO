package Symulacja;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Glowna klasa Ekosystem
 *
 * Zawiera w sobie podprogram głowny main.
 * Daje uzytkownikowi prawo do zmieniania rozmiaru planszy, liczby iteracji oraz ilosci obiektow na planszy.
 *
 */

public class Ekosystem {
    /**
     * Zmienne klasy Ekosystem
     */
    public String nazwa;
    public int iteracje_symulacji;
    Plansza plansza;

    /**
     * Konstruktor klasy Ekosystem
     *
     * Domyslna nazwa obiektu jest Las.
     * @param iteracje - tutaj podawana jest ilosc iteracji symulacji.
     */
    public Ekosystem(int iteracje) {
        this.nazwa = "Las";
        this.iteracje_symulacji = iteracje;
    }

    /**
     * Metoda odczytaj_konfiguracje
     *
     * Odpowiedzialna za zapisanie ustawien konfiguracji użytkownika do pliku konfiguracja.txt.
     * Plik zostanie wykorzystany do wywolania symulacji ze zgodnym rozmiarem oraz odpowiednia liczba zwierzat oraz roslin.
     */
    public void odczytaj_konfiguracje() {
        List<String> konfiguracja = new ArrayList<>();
        konfiguracja.add("Liczba wilkow: " + plansza.liczba_wilkow);
        konfiguracja.add("Liczba jeleni: " + plansza.liczba_jeleni);
        konfiguracja.add("Liczba saren: " + plansza.liczba_saren);
        konfiguracja.add("Liczba dzikow: " + plansza.liczba_dzikow);
        konfiguracja.add("Liczba traw: " + plansza.liczba_traw);
        konfiguracja.add("Liczba zoledzi: " + plansza.liczba_zoledzi);
        try {
            FileWriter zapis = new FileWriter("konfiguracja.txt");
            zapis.write(String.valueOf(konfiguracja));
            zapis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Konfiguracje startowa zapisano do pliku konfiguracja.txt");

    }

    /**
     * Metoda uruchom_symulacje
     *
     * Odpowiedzialna za zapisanie historii poruszania obiektow w symulacji do pliku rezultat.txt.
     * Pokazuje współrzedne przed wykonaniem ruchu jak i po wykonaniu ruchu.
     */
    public void uruchom_symulacje() {
        odczytaj_konfiguracje();
        int iteracje = iteracje_symulacji;
        List<String> rezultat = new ArrayList<>();
        do {
            if (plansza.zwierzeta.isEmpty()) break;
            for (Zwierze zwierze : plansza.zwierzeta) {
                rezultat.add("Przed wykonianiem ruchu: ");
                rezultat.add(zwierze.gatunek + ": " + zwierze.pozycja_X + ";" + zwierze.pozycja_Y);
                zwierze.poruszanie(plansza);
                rezultat.add("Po wykonianiu ruchu: ");
                rezultat.add(zwierze.gatunek + ": " + zwierze.pozycja_X + ";" + zwierze.pozycja_Y);
            }
            plansza.zwierzeta.removeIf(zwierze -> (!zwierze.czy_zyje));
            plansza.rosliny.removeIf(roslina -> (!roslina.czy_rosnie));
            rezultat.add("Ilosc zwierzat: " + plansza.zwierzeta.size());
        } while (--iteracje > 0);
        try {
            FileWriter zapis = new FileWriter("rezultat.txt");
            zapis.write(String.valueOf(rezultat));
            zapis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Zapisano dane do pliku rezultat.txt");

    }

    /**
     * Podprogram główny main
     *
     * Zawiera domyslne ustawienia symulacji oraz jest odpowiedzialny za wywolywanie innych metod programu.
     * Stanowi przejrzysty interfejs między programem, a użytkownikiem.
     * Uzytkownik może manipulowac liczbą zwierząt i roślin, jak rowniez szerokoscia oraz wysokoscia planszy.
     * @param args - domyslny argument metody statycznej main.
     */
    public static void main(String[] args) {

        int wyjscie = 0;
        int rozmiar_x = 5;
        int rozmiar_y = 5;
        int iteracje = 5;
        int ilosc_wilkow = 4;
        int ilosc_jeleni = 3;
        int ilosc_saren = 3;
        int ilosc_dzikow = 2;
        int ilosc_zoledzi = 1;
        int ilosc_traw = 2;
        Scanner scan = new Scanner(System.in);

        //MENU
        while (wyjscie == 0) {
            System.out.println("MENU");
            System.out.println("1. Ustaw rozmiar planszy (domyslnie 5x5)");
            System.out.println("2. Ustaw liczbe iteracji (domyslnie 5)");
            System.out.println("3. Dodaj zwierzeta");
            System.out.println("4. Dodaj rosliny");
            System.out.println("5. Rozpocznij symulacje");
            System.out.println("6. Wyjscie");
            System.out.print("Wybierz opcje: ");
            int opcja = scan.nextInt();
            switch (opcja) {
                case 1: {
                    System.out.print("Podaj szerokosc planszy: ");
                    rozmiar_x = scan.nextInt();
                    System.out.print("Podaj wysokosc planszy: ");
                    rozmiar_y = scan.nextInt();
                }
                break;
                case 2: {
                    System.out.print("Podaj liczbe iteracji: ");
                    iteracje = scan.nextInt();
                }
                break;
                case 3: {
                    System.out.println("Jakie zwierze chcesz dodać do symulacji?");
                    System.out.println("1. Wilk (domyslnie 4)");
                    System.out.println("2. Dzik (domyslnie 2)");
                    System.out.println("3. Jelen (domyslnie 3)");
                    System.out.println("4. Sarna (domyslnie 3)");
                    System.out.println("5. Powrót");
                    System.out.print("Wybierz opcje: ");
                    int wybor_zwierzecia = scan.nextInt();
                    switch (wybor_zwierzecia) {
                        case 1: {
                            System.out.print("Podaj ilosc: ");
                            ilosc_wilkow = scan.nextInt();
                        }
                        break;
                        case 2: {
                            System.out.print("Podaj ilosc: ");
                            ilosc_dzikow = scan.nextInt();
                        }
                        break;
                        case 3: {
                            System.out.print("Podaj ilosc: ");
                            ilosc_jeleni = scan.nextInt();
                        }
                        break;
                        case 4: {
                            System.out.print("Podaj ilosc: ");
                            ilosc_saren = scan.nextInt();
                        }
                        break;
                    }
                }
                break;
                case 4: {
                    System.out.println("Jaka rosline chcesz dodać do symulacji?");
                    System.out.println("1. Trawa (domyslnie 2)");
                    System.out.println("2. Żołądź (domyslnie 1)");
                    System.out.println("3. Powrót");
                    System.out.print("Wybierz opcje: ");
                    int wybor_rosliny = scan.nextInt();
                    switch (wybor_rosliny) {
                        case 1: {
                            System.out.print("Podaj ilosc: ");
                            ilosc_traw = scan.nextInt();
                        }
                        break;
                        case 2: {
                            System.out.print("Podaj ilosc: ");
                            ilosc_zoledzi = scan.nextInt();
                        }
                        break;
                    }
                    break;
                }
                case 5: {
                    Ekosystem ekosystem = new Ekosystem(iteracje);
                    var plansza = new Plansza(rozmiar_x, rozmiar_y, ilosc_wilkow, ilosc_saren, ilosc_jeleni, ilosc_dzikow, ilosc_traw, ilosc_zoledzi);
                    ekosystem.plansza = plansza;
                    plansza.przechowywanie_zwierzat();
                    plansza.przechowywanie_roslin();
                    ekosystem.uruchom_symulacje();
                }
                break;
                case 6: {
                    wyjscie = 1;
                }
            }
        }
    }

}
