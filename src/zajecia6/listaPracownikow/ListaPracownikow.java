package zajecia6.listaPracownikow;

import java.util.Scanner;

public class ListaPracownikow {
    private Pracownik[] lista = new Pracownik[100];
    private int liczbaPracownikow = 0;
    Scanner sc = new Scanner(System.in);
    public static final String BASE_PATH = System.getProperty("user.home") + "/Dysk Google/Kurs Java/files/";

    // konstruktor uruchamia funkcje do celow testowych
    public ListaPracownikow() {
        generujPracownikow();
        //dodajPracownika();
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
            char plec = pobierzPlec();
            System.out.print("Podaj nr działu:");
            int nrDzialu = Integer.parseInt(sc.nextLine());
            System.out.print("Podaj płacę:");
            float placa = Float.parseFloat(sc.nextLine());
            System.out.print("Podaj wiek:");
            int wiek = Integer.parseInt(sc.nextLine());
            System.out.print("Podaj liczbę dzieci:");
            int liczbaDzieci = Integer.parseInt(sc.nextLine());
            boolean stanCywilny = pobierzStanCywilny();

            Pracownik pracownik = new Pracownik(imie, nazwisko, plec, nrDzialu, placa, wiek, liczbaDzieci, stanCywilny);
            lista[liczbaPracownikow++] = pracownik;

        } else {
            System.out.println("Błąd. Lista jest pełna.");
            Menu.nacisnijEnter();
        }

    }

    // funckja 3
    String eksport() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Eksport do pliku tekstowego. Podaj nazwę pliku:");
        String fileName = sc.nextLine();
        if ((fileName == null || fileName.isBlank()) ) {
            System.out.println("Nieprawidłowa nazwa pliku.");
            Menu.nacisnijEnter();
            return null;
        }
        try {
            //TODO Pass deep copy of lista to external export class
            Pliki pliki = new Pliki(BASE_PATH + fileName, lista, liczbaPracownikow);
            pliki.exportAllToFile();
            return fileName;
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
            return null;
        }
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

        System.out.print("Podaj numer pracownika do usunięcia lub 'q' aby anulować:");
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

    public void edycjaDanych() {
        System.out.println("*** Edycja danych pracowników ***");
        System.out.println("Liczba pracowników w bazie: " + liczbaPracownikow);

        for (int i = 0; i < liczbaPracownikow; i++) {
            System.out.println("*********");
            System.out.println("Pracownik nr: " + (i) + ":");
            lista[i].wyswietlOkrojone();
        }

        if (liczbaPracownikow == 0) {
            System.out.print("Lista jest pusta. ");
            Menu.nacisnijEnter();
            return;
        }

        System.out.println("Podaj numer pracownika do edycji lub 'q' aby anulować:");
        String akcja = sc.nextLine();
        if (akcja.equals("q")) {
            return;
        }
        int nrPracDoEdycji = Integer.parseInt(akcja);
        if (nrPracDoEdycji >= liczbaPracownikow) {
            System.out.println("Nieprawidłowy nr pracownika! Wciśnij Enter aby wyjść do Menu Głównego");
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
            System.out.println("BŁĄD! Nazwisko można edytować tylko kobietom. ");
            Menu.nacisnijEnter();
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

    public void generujPracownikow() {
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

    private char pobierzPlec() {
        char inputChar = '?';
        boolean nieprawidloweDane;

        do {
            System.out.print("Podaj płeć (M/K):");
            try {
                inputChar = sc.nextLine().toUpperCase().charAt(0);
                nieprawidloweDane = (inputChar != 'M' && inputChar != 'K');
            } catch (Exception e) {
                nieprawidloweDane = true;
            }

            if (nieprawidloweDane) {
                System.out.println("Podano nieprawidłowe dane!");
            }
        } while (nieprawidloweDane);

        return inputChar;
    }

    private boolean pobierzStanCywilny() {
        char inputChar = '?';
        boolean nieprawidloweDane;

        do {
            System.out.print("Podaj stan cywilny (W - wolny, Z - zajęty:");
            try {
                inputChar = sc.nextLine().toUpperCase().charAt(0);
                nieprawidloweDane = (inputChar != 'W' && inputChar != 'Z');
            } catch (Exception e) {
                nieprawidloweDane = true;
            }

            if (nieprawidloweDane) {
                System.out.println("Podano nieprawidłowe dane!");
            }
        } while (nieprawidloweDane);

        return inputChar == 'Z';
    }

    public void dodatkoweFunkcje(Menu menu){
        String wybor = "";

        while (!wybor.equals("q") && !wybor.equals("e")) {
            menu.wyswietlPodmenu6();
            wybor = menu.pobierzAkcjeOdUzytkownika();
            switch (wybor) {
                case "1": {
                    liczbaPracownikowPowPensji();
                    break;
                }
                case "2": {
                    sredniaPlacaWDziale();
                    break;
                }
                case "3": {
                    najwiekszePlaceWgPlci();
                    break;
                }
                case "4" : {
                    statystykaDzialow();
                    break;
                }
                case "5" : {
                    stosunekSrednichPlacKobietMezczyzn();
                    break;
                }
                case "6" : {
                    zwiekszPensjeO_10prc();
                    break;
                }
                case "7" : {
                    zwiekszPensjeOKwote();
                    break;
                }
                case "8" : {
                    sortujWgNazwiska();
                    break;
                }
                case "9" : {
                    sortujWgPensji();
                    break;
                }
                case "q":
                case "e": {
                    break;
                }
                default: {
                    System.out.print("Nieprawidłowa opcja.");
                    Menu.nacisnijEnter();
                }
            }
        }
    }

    private void liczbaPracownikowPowPensji() {
        System.out.print("Podaj pensję progową:");
        float prog = Float.parseFloat(sc.nextLine());
        int licznik = 0;
        for (int i = 0; i < liczbaPracownikow; i++) {
            if (lista[i].getPlaca() >= prog) {
                licznik++;
            }
        }
        System.out.println("Liczba pracowników z płącą nie mniejszą niż " + prog + ": " + licznik);
        Menu.nacisnijEnter();
    }

    private void sredniaPlacaWDziale() {
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
        } else {
            System.out.println("Średnia płaca w dziale nr " + nrDzialu + " wynosi: " + suma / licznik);
        }
        Menu.nacisnijEnter();
    }

    private void najwiekszePlaceWgPlci() {
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
        Menu.nacisnijEnter();
    }

    private void statystykaDzialow() {
        int maxNrDzialu = 0;
        for (int i = 0; i < liczbaPracownikow; i++) {
            if (lista[i].getNrDzialu() > maxNrDzialu) {
                maxNrDzialu = lista[i].getNrDzialu();
            }
        }

        for (int nrDzialu = 0; nrDzialu <= maxNrDzialu; nrDzialu++) {
            int licznikM = 0;
            int licznikK = 0;
            float suma = 0;
            for (int j = 0; j < liczbaPracownikow; j++) {
                if (lista[j].getNrDzialu() == nrDzialu) {
                    if (lista[j].getPlec() == 'M') {
                        licznikM++;
                    }
                    if (lista[j].getPlec() == 'K') {
                        licznikK++;
                    }
                    suma += lista[j].getPlaca();
                }
            }
            if (licznikK > 0 || licznikM > 0) {
                if (licznikK > licznikM) {
                    System.out.println("W dziale " + nrDzialu + " jest więcej kobiet.");
                } else if (licznikM > licznikK) {
                    System.out.println("W dziale " + nrDzialu + " jest więcej mężczyzn.");
                } else {
                    System.out.println("W dziale " + nrDzialu + " jest tyle samo mężczyzn co kobiet.");
                }
                System.out.println("Średnia pensja w dziale " + nrDzialu + " wynosi: " +
                        (suma / (licznikM+licznikK)) );
                Menu.nacisnijEnter();
            }
        }
    }

    private void stosunekSrednichPlacKobietMezczyzn() {
        int licznikM = 0;
        int licznikK = 0;
        float sumaK = 0;
        float sumaM = 0;
        for (int i = 0; i < liczbaPracownikow; i++) {
            if (lista[i].getPlec() == 'M') {
                licznikM++;
                sumaM += lista[i].getPlaca();
            }
            if (lista[i].getPlec() == 'K') {
                licznikK++;
                sumaK += lista[i].getPlaca();
            }
        }
        if (licznikM > 0 && licznikK > 0) {
            System.out.println("Stosunek średniej płacy kobiet do średniej płący mężczyzn wynosi: " +
                    ((sumaK / licznikK) / (sumaM / licznikM)));
        } else if (licznikM == 0 && licznikK == 0){
            System.out.println("W bazie nie ma pracowników!");
        } else if (licznikM == 0) {
            System.out.println("W bazie nie ma mężczyzn!");
        } else {
            System.out.println("W bazie nie ma kobiet!");
        }
        Menu.nacisnijEnter();
    }

    private void zwiekszPensjeO_10prc() {
        for (int i = 0; i < liczbaPracownikow; i++) {
            lista[i].setPlaca( lista[i].getPlaca() + lista[i].obliczPodwyzke(10.0f) );
        }
        System.out.println("Pensje zwiększono.");
        Menu.nacisnijEnter();
    }

    private void zwiekszPensjeOKwote() {
        System.out.print("Zwiększanie pensji wszystkim. Podaj kwotę:");
        float kwotaPodwyzki = Float.parseFloat(sc.nextLine());
        float stosunekPodwyzekM = podwyzkaKwotowa(kwotaPodwyzki, 'M');
        System.out.println("Stosunek podwyżek dla mężczyzn wyniósł: " + stosunekPodwyzekM);
        float stosunekPodwyzekK = podwyzkaKwotowa(kwotaPodwyzki, 'K');
        System.out.println("Stosunek podwyżek dla kobiet wyniósł: " + stosunekPodwyzekK);
        Menu.nacisnijEnter();
    }

    private void sortujWgNazwiska() {
        char kierunek;
        do {
            System.out.print("Sortowanie według nazwiska. Podaj kierunek - [r]osnąco / [m]alejąco:");
            String s = sc.nextLine();
            if (s.isEmpty()) {
                kierunek = 'r';
            } else {
                kierunek = s.toLowerCase().charAt(0);
            }
        } while (kierunek != 'r' && kierunek != 'm');
        sortujPoNazwisku(kierunek == 'r');
        System.out.println(("Posortowano " + ((kierunek == 'r') ? "rosnąco" : "malejąco")));
        Menu.nacisnijEnter();
    }

    private void sortujWgPensji() {
        char kierunek;
        do {
            System.out.print("Sortowanie według pensji. Podaj kierunek - [r]osnąco / [m]alejąco:");
            String s = sc.nextLine();
            if (s.isEmpty()) {
                kierunek = 'r';
            } else {
                kierunek = s.toLowerCase().charAt(0);
            }
        } while (kierunek != 'r' && kierunek != 'm');
        sortujWgPensji(kierunek == 'r');
        System.out.println(("Posortowano " + ((kierunek == 'r') ? "rosnąco" : "malejąco")));
        Menu.nacisnijEnter();
    }

    //TODO Wydzielić operacje na plikach do osobnej klasy
    public void funkcjePlikowTekstowych(Menu menu) {
        String nazwaPliku = eksport();
        if (nazwaPliku == null) {
            return;
        }
        Pliki pliki = new Pliki(BASE_PATH + nazwaPliku);
        String wybor = "";

        while (!(wybor.equals("q") || wybor.equals("e"))) {
            menu.wyswietlPodmenu7();
            wybor = menu.pobierzAkcjeOdUzytkownika();
            switch (wybor) {
                case "1": {
                    try {
                        pliki.wyswietlDaneNajdluzszeNazwisko();
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                }
                case "2" : {
                    try {
                        pliki.obliczSredniaWiekuOsobZDziecmi();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "3" : {
                    try {
                        pliki.zakodujPlik();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "4" : {
                    try {
                        pliki.utworzHTML();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "q":
                case "e": {
                    break;
                }
                default: {
                    System.out.print("Nieprawidłowa opcja.");
                    Menu.nacisnijEnter();
                }
            }
        }
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

    private void sortujPoNazwisku(boolean rosnaco) {
        Pracownik pomocniczy;
        for (int i = 0; i < liczbaPracownikow - 1; i++) {
            for (int j = i + 1; j < liczbaPracownikow; j++) {
                if (rosnaco) {
                    if (lista[i].getNazwisko().compareTo(lista[j].getNazwisko()) > 0) {
                        pomocniczy = lista[i];
                        lista[i] = lista[j];
                        lista[j] = pomocniczy;
                    }
                } else {
                    if (lista[i].getNazwisko().compareTo(lista[j].getNazwisko()) < 0) {
                        pomocniczy = lista[i];
                        lista[i] = lista[j];
                        lista[j] = pomocniczy;
                    }
                }
            }
        }
    }

    private void sortujWgPensji(boolean rosnaco) {
        Pracownik pomocniczy;
        int indeks;
        float wartoscMaxMin;
        for (int i = 0; i < liczbaPracownikow - 1; i++) {
            wartoscMaxMin = lista[i].getPlaca();
            indeks = i;
            for (int j = i + 1; j < liczbaPracownikow; j++) {
                if (rosnaco) {
                    if ( lista[j].getPlaca() < wartoscMaxMin) {
                        indeks = j;
                        wartoscMaxMin = lista[j].getPlaca();
                    }
                } else {
                    if ((int) lista[j].getPlaca() > wartoscMaxMin) {
                        indeks = j;
                        wartoscMaxMin = lista[j].getPlaca();
                    }
                }
            }
            if (indeks != i) {
                pomocniczy = lista[i];
                lista[i] = lista[indeks];
                lista[indeks] = pomocniczy;
            }
        }
    }

    private float podwyzkaKwotowa(float kwota, char plec) {
        float sumaPlacBazowych = 0;
        float sumaPlacPoPodwyzce = 0;
        float sumaPodwyzek = 0;
        for (int i = 0; i < liczbaPracownikow; i++) {
            if (lista[i].getPlec() == plec) {
                sumaPlacBazowych+= lista[i].getPlaca();
                lista[i].setPlaca(lista[i].getPlaca() + kwota);
                sumaPlacPoPodwyzce+= lista[i].getPlaca();
                sumaPodwyzek+= kwota;
            }
        }
        System.out.println("Suma podwyżek dla " + (plec == 'M' ? "mężczyzn " : "kobiet ") + "wyniosła: " + sumaPodwyzek);
        return ( (sumaPlacBazowych == 0) ? 0.0f : (sumaPlacPoPodwyzce / sumaPlacBazowych) );
    }

}