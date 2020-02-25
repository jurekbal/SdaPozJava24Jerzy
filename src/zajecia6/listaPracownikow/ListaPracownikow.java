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
                'M', 1, 150, 26, 2, false);

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
            System.out.println("Nieprawidłowa opcja! Wciśnij Enter aby wyjść do Menu Głównego");
            sc.nextLine();
            return;
        }
        if (nrOpcji == 2 && lista[nrPracDoEdycji].getPlec() != 'K'){
            System.out.println("BŁĄD! Nazwisko można edytować tylko kobietom. Wciśnij Enter...");
            sc.nextLine();
            return;
        }

        //TODO Edycja danych: kontrola wprowadzania, kontrola danych
        switch (nrOpcji) {
            case 2: {
                System.out.print("Podaj nowe nazwisko [aktualnie: " + lista[nrPracDoEdycji].getNazwisko() + "]:");
                String linia = sc.nextLine();
                lista[nrPracDoEdycji].setNazwisko(kapitalka(linia));
                System.out.println("Nazwisko pracownika nr " + nrPracDoEdycji + " zmieniono na: " + linia);
                break;
            }
            case 4: {
                System.out.print("Podaj nr działu [aktualnie: " + lista[nrPracDoEdycji].getNrDzialu() + "]:");
                lista[nrPracDoEdycji].setNrDzialu(Integer.parseInt(sc.nextLine()));
                System.out.println("Numer działu zmieniono na: " + lista[nrPracDoEdycji].getNrDzialu());
                break;
            }
            case 5 : {
                System.out.print("Podaj nową płącę [aktualnie: " + lista[nrPracDoEdycji].getPlaca() + "]:");
                lista[nrPracDoEdycji].setPlaca(Float.parseFloat(sc.nextLine()));
                System.out.println("Płacę zmieniono na: " + lista[nrPracDoEdycji].getPlaca());
                break;
            }
            case 6 : {
                System.out.print("Podaj wiek [aktualnie: " + lista[nrPracDoEdycji].getWiek() + "]:");
                lista[nrPracDoEdycji].setWiek(Integer.parseInt(sc.nextLine()));
                System.out.println("Wiek zmieniono na: " + lista[nrPracDoEdycji].getWiek());
                break;
            }
            case 7 : {
                System.out.print("Podaj nową liczbę dzieci [aktualnie: "
                        + lista[nrPracDoEdycji].getLiczbaDzieci() + "]:");
                lista[nrPracDoEdycji].setLiczbaDzieci(Integer.parseInt(sc.nextLine()));
                System.out.println("Liczbę dzieci zmieniono na: " + lista[nrPracDoEdycji].getLiczbaDzieci());
                break;
            }
            case 8 : {
                System.out.print("Podaj aktualny stan cywilny (W - wolny, Z - zajęty [obecnie: "
                        + (lista[nrPracDoEdycji].isStanCywilny() ? "zajęty" : "wolny") +"]:");
                char stanCywilnyChar = (sc.nextLine().toUpperCase().charAt(0));
                lista[nrPracDoEdycji].setStanCywilny(stanCywilnyChar == 'Z');
                System.out.println("Stan cywilny zmieniono na: "
                        + (lista[nrPracDoEdycji].isStanCywilny() ? "zajęty" : "wolny"));
                break;
            }
        }
        System.out.println("Powrót do głównego menu - wciśnij Enter");
        sc.nextLine();

    }

    // funkcja 6
    public void dodatkoweFunkcje(Menu menu){
        String wybor = "";

        while (!wybor.equals("q") && !wybor.equals("e")) {
            menu.wyswietlPodmenu6();
            wybor = menu.pobierzAkcjeOdUzytkownika();
            switch (wybor) {
                case "1": {
                    System.out.print("Podaj pensję progową:");
                    float prog = Float.parseFloat(sc.nextLine());
                    int licznik = 0;
                    for (int i = 0; i < liczbaPracownikow; i++) {
                        if (lista[i].getPlaca() >= prog) {
                            licznik++;
                        }
                    }
                    System.out.println("Liczba pracowników z płącą nie mniejszą niż " + prog + ": " + licznik);
                    System.out.println("Wciśnij Enter...");
                    sc.nextLine();
                    break;
                }
                case "2": {
                    System.out.print("Podaj numer działu:");
                    int nrDzialu = Integer.parseInt(sc.nextLine());
                    int licznik = 0;
                    float suma = 0;
                    for (int i = 0; i < liczbaPracownikow; i++) {
                        if (lista[i].getNrDzialu() == nrDzialu) {
                            licznik++;
                            suma += lista[i].getPlaca();
                        }
                    }
                    if (licznik == 0) {
                        System.out.println("Nie ma nikogo w dziale nr " + nrDzialu);
                        System.out.println("Wciśnij Enter...");
                        sc.nextLine();
                    } else {
                        System.out.println("Średnia płaca w dziale nr " + nrDzialu + " wynosi: " + suma / licznik);
                        System.out.println("Wciśnij Enter...");
                        sc.nextLine();
                    }
                    break;
                }
                case "3": {
                    float maxKobiety = 0;
                    float maxMezczyzni = 0;
                    for (int i = 0; i < liczbaPracownikow; i++) {
                        if (lista[i].getPlec() == 'K') {
                            if (lista[i].getPlaca() > maxKobiety) {
                                maxKobiety = lista[i].getPlaca();
                            }
                        }
                        if (lista[i].getPlec() == 'M') {
                            if (lista[i].getPlaca() > maxMezczyzni) {
                                maxMezczyzni = lista[i].getPlaca();
                            }
                        }
                    }
                    System.out.println("Maksymalne płace: Mężczyźni: " + maxMezczyzni + "; Kobiety: " + maxKobiety + ";");
                    System.out.println("Wciśnij Enter...");
                    sc.nextLine();
                }
                case "q":
                case "e": {
                    break;
                }
                default: {
                    System.out.println("Nieprawidłowa opcja. Powrót do głównego menu.");
                }
            }
        }
    }

    // funkcja 99
    public void generuj() {
        Generator generator = new Generator();
        System.out.print("Ilu pracowników wygenerować?:");
        int ileDodac = Integer.parseInt(sc.nextLine());
        if (liczbaPracownikow + ileDodac > 100) {
            ileDodac = 100 - liczbaPracownikow;
        }
        for (int i = liczbaPracownikow; i < liczbaPracownikow + ileDodac; i++) {
            lista[i] = generator.generuj();
        }
        liczbaPracownikow+= ileDodac;
        System.out.println("Wygenerowano " + ileDodac + " pracowników/a. Masz w bazie " + liczbaPracownikow +
                " pracowników.");
        System.out.println("Wciśnij Enter...");
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