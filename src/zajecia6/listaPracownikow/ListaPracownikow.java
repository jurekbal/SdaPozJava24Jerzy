package zajecia6.listaPracownikow;

import java.util.Scanner;

public class ListaPracownikow {
    private Pracownik[] lista = new Pracownik[100];
    private int liczbaPracownikow = 0;
    Scanner sc = new Scanner(System.in);

    // konstruktor wklepuje na stałe dwóch pracownikow do celów testowych
    public ListaPracownikow() {
        Pracownik filip = new Pracownik("Filip", "Forszpaniak",
                'M', 1, 200, 31, 0, true);
        Pracownik karol = new Pracownik("Karol", "Nowak",
                'M', 2, 150, 26, 2, false);

        lista[liczbaPracownikow++] = filip;
        lista[liczbaPracownikow++] = karol;

    }

    // funkcja 1
    public void wypiszWszystkich() {
        System.out.println("*** Lista pracowników ***");
        System.out.println("Liczba pracowników w bazie: " + liczbaPracownikow);

        for (int i = 0; i < liczbaPracownikow; i++) {
            System.out.println("*********");
            System.out.println("Pracownik nr: " + (i) + ":");
            lista[i].wyswietlOkrojone();
        }

        if (liczbaPracownikow == 0) {
            System.out.println("Lista jest pusta.");
        }

        System.out.println("Nasisnij Enter aby wrócić do Menu Głównego");
        sc.nextLine();
    }

    // funkcja 2
    public void dodajPracownika() {
        System.out.println("*** Dodawanie pracownika ***");
        if (liczbaPracownikow < 100) {

            System.out.println("dodajesz pracownika nr " + liczbaPracownikow);
            System.out.print("Podaj Imię:");
            String imie = kapitalka(sc.nextLine());
            System.out.print("Podaj Nazwisko:");
            String nazwisko = kapitalka(sc.nextLine());
            System.out.print("Podaj płeć (M/K):");
            char plec = (sc.nextLine().toUpperCase().charAt(0));
            //TODO kontrola wprowadzania: płeć
            System.out.print("Podaj nr działu:");
            int nrDzialu = Integer.parseInt(sc.nextLine());
            System.out.print("Podaj płacę:");
            float placa = Float.parseFloat(sc.nextLine());
            System.out.print("Podaj wiek:");
            int wiek = Integer.parseInt(sc.nextLine());
            System.out.print("Podaj liczbę dzieci:");
            int liczbaDzieci = Integer.parseInt(sc.nextLine());
            System.out.print("Podaj stan cywilny (W - wolny, Z - zajęty:");
            char stanCywilnyChar = (sc.nextLine().toUpperCase().charAt(0));
            boolean stanCywilny;
            stanCywilny = stanCywilnyChar == 'Z'; //true / false
            //TODO kontrola wprowadzania: stan cywilny

            Pracownik pracownik = new Pracownik(imie, nazwisko, plec, nrDzialu, placa, wiek, liczbaDzieci, stanCywilny);
            lista[liczbaPracownikow++] = pracownik;

        } else {
            System.out.println("Błąd. Lista jest pełna.");
        }

    }

    // funckja 3
    public void eksport() {
        // TODO implemantacja funkcji 3
    }

    // funkcja 4
    public void usunPracownika() {
        System.out.println("*** Usuwanie pracowników ***");
        System.out.println("Liczba pracowników w bazie: " + liczbaPracownikow);

        for (int i = 0; i < liczbaPracownikow; i++) {
            System.out.println("*********");
            System.out.println("Pracownik nr: " + (i) + ":");
            lista[i].wyswietlOkrojone();
        }

        if (liczbaPracownikow == 0) {
            System.out.println("Lista jest pusta.");
        }

        System.out.println("Podaj numer pracownika do usunięcia lub 'q' aby anulować:");
        String akcja = sc.nextLine();
        if (akcja.equals("q")) {
            return;
        }
        int nrPracDoUsuniecia = Integer.parseInt(akcja);
        if (nrPracDoUsuniecia >= liczbaPracownikow) {
            System.out.println("Nieprawidłowy nr pracownika! Wciśnij Enter aby wyjść do Menu G");
            sc.nextLine();
            return;
        }

        lista[nrPracDoUsuniecia] = null;
        for (int i = nrPracDoUsuniecia; i < liczbaPracownikow; i++) {
            lista[i] = lista[i+1];
        }
        liczbaPracownikow--;

    }

    // funkcja 5
    public void edycjaDanych() {
        System.out.println("*** Edycja danych pracowników ***");
        System.out.println("Liczba pracowników w bazie: " + liczbaPracownikow);

        for (int i = 0; i < liczbaPracownikow; i++) {
            System.out.println("*********");
            System.out.println("Pracownik nr: " + (i) + ":");
            lista[i].wyswietlOkrojone();
        }

        if (liczbaPracownikow == 0) {
            System.out.println("Lista jest pusta.");
        }

        System.out.println("Podaj numer pracownika do edycji lub 'q' aby anulować:");
        String akcja = sc.nextLine();
        if (akcja.equals("q")) {
            return;
        }
        int nrPracDoEdycji = Integer.parseInt(akcja);
        if (nrPracDoEdycji >= liczbaPracownikow) {
            System.out.println("Nieprawidłowy nr pracownika! Wciśnij Enter aby wyjść do Menu G");
            sc.nextLine();
            return;
        }

        lista[nrPracDoEdycji].wyswietlWszystko();
        System.out.println("Co chcesz edytować?\n2: nazwisko (tylko kobiety)\n4: nr działu\n5: płaca\n" +
                "6: wiek\n7: liczba dzieci\n8: stan cywilny");
        akcja = sc.nextLine();
        int nrOpcji = Integer.parseInt(akcja);
        if (nrOpcji < 2 || nrOpcji == 3 || nrOpcji > 8) {
            System.out.println("Nieprawidłowa opcja! Wciśnij Enter aby wyjść do Menu G");
            sc.nextLine();
            return;
        }
        if (nrOpcji == 2 && lista[nrPracDoEdycji].getPlec() != 'K'){
            System.out.println("BŁĄD! Nazwisko można edytować tylko kobietom. Wciśnij Enter...");
            sc.nextLine();
            return;
        }

        //TODO do optymalizacji i uzuzpełnienia
        switch (nrOpcji) {
            case 2: {
                System.out.println("Podaj nowe nazwisko [" + lista[nrPracDoEdycji].getNazwisko() + "]:");
                String linia = sc.nextLine();

            }

        }
        //TODO Realizacja edycji pól

        sc.nextLine();

    }

    private String kapitalka(String line){
        if (line.length() > 0) {
            line = line.toLowerCase();
            String firstChar = line.substring(0, 1);
            line = line.substring(1);
            firstChar = firstChar.toUpperCase();
            return firstChar + line;
        } else {
            return "";
        }
    }
}