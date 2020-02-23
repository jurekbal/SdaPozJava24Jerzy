package zajecia7.zadaniaDomowe;

import java.util.Random;
import java.util.Scanner;

// klasa do metody OOP
public class Wisielec {

    private int poczatowaLiczbaZyc;
    private int liczbaZyc;
    private String slowo;
    private String[] tablicaHasel = {"foobar", "foo", "bar", "baz", "qux", "quux", "quuz", "corge", "grault", "garply", "waldo", "fred", "plugh", "xyzzy", "and", "thud"};
    char litera;
    private boolean[] odgadnieta = new boolean[100];
    private boolean wyjscie = false;
    private boolean wygrana;
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    public Wisielec(int poczatowaLiczbaZyc) {
        this.poczatowaLiczbaZyc = (poczatowaLiczbaZyc < 1) ? 5 : poczatowaLiczbaZyc;
    }

    public Wisielec(){
        this(5);
    }

    public void start() {
        liczbaZyc = poczatowaLiczbaZyc;
        System.out.println("<<< Gra wisielec - witamy >>>");
        System.out.print("Podaj tryb gry: (1) - hasło ze słownika; (2) - hasło wpisuje gracz:");
        litera = scanner.nextLine().charAt(0);
        if (litera == '1') {
            slowo = tablicaHasel[random.nextInt(tablicaHasel.length)];
        } else {
            System.out.print("Podaj hasło dla przeciwnika:");
            slowo = scanner.nextLine().toLowerCase();
        }
        for (int i = 0; i < slowo.length(); i++) {
            odgadnieta[i] = false;
        }
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    public void status() {
        System.out.println("Liczba żyć: " + liczbaZyc);
        System.out.print("Słowo: ");
        for (int i = 0; i < slowo.length(); i++) {
            if (odgadnieta[i]) {
                System.out.print(slowo.charAt(i));
            } else {
                System.out.print("*");
            }
        }
        System.out.println();
    }

    public boolean zgaduj() {
        System.out.print("Podaj jeden znak: ");
        String odczyt = scanner.nextLine();
        if (odczyt.length() > 1) {
            System.out.println("Podałeś za dużo znaków. Tracisz życie!");
            liczbaZyc--;
        } else if (odczyt.isEmpty()) {
            System.out.println("Nie podałeś litery. Tracisz życie!");
            liczbaZyc--;
        } else {
            litera = odczyt.toLowerCase().charAt(0);
            return true;
        }
        return false;
    }

    public void sprawdzTrafienie(){
        boolean trafiony = false;
        boolean juzBylTrafiony = false;
        wygrana = true;
        for (int i = 0; i < slowo.length(); i++) {
            if (slowo.charAt(i) == litera) {
                if (odgadnieta[i]) {
                    juzBylTrafiony = true;
                }
                odgadnieta[i] = true;
                trafiony = true;
            }
            if (!odgadnieta[i]) {
                wygrana = false;
            }
        }
        // wyswietl rezultat typowania
        if (trafiony) {
            if (!juzBylTrafiony) {
                System.out.println("Brawo! Trafiony.");
            } else {
                System.out.println("Już trafiłeś tą literę.");
            }
        } else {
            System.out.println("Brak trafienia. Utrata życia.");
            liczbaZyc--;
        }
    }

    public void sprawdzWygrana(){
        if (wygrana) {
            System.out.println("Brawo! Wygrałeś");
            System.out.println("Szukane słowo to: " + slowo);
        }
        if (liczbaZyc < 1) {
            System.out.println("*** Przegrałeś grę! ***");
            System.out.println("Szukane złowo to: " + slowo);
        }
    }

    public boolean wyjscie(){
        do {
            System.out.println("Czy chcesz nadal grać? (t/n):");
            litera = scanner.nextLine().toLowerCase().charAt(0);
        } while (litera != 't' && litera != 'n');
        return (litera == 'n');
    }

    public int getLiczbaZyc() {
        return liczbaZyc;
    }

    public boolean isWygrana() {
        return wygrana;
    }
}
