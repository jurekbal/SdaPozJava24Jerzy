package zajecia7.zadaniaDomowe;

import java.util.Random;
import java.util.Scanner;

// Zadania do domu_weekend_1.pdf - zad 6
public class Szyfrolamacz {

    private int liczba;
    private int[] cyfry = new int[4];
    private int liczbaZyc;
    private boolean ratunek;
    private boolean wygrana;
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    public void start() {
        System.out.println("<<< Gra Szyfrołamacz - witamy >>>");
        liczbaZyc = 5;
        ratunek = true;
        wygrana = false;
        liczba = random.nextInt(10000);
        int temp = liczba;
        for (int i = 3; i >= 0 ; i--) {
            cyfry[i] = temp % 10;
            temp /= 10;
        }
    }

    public void typowanie(){
        System.out.println("Pozostała liczba żyć: " + liczbaZyc);
        if (ratunek) {
            System.out.print("Podaj liczbę - 4 cyfry - w formacie XXXX lub '?' dla podpowiedzi:");
        } else {
            System.out.print("Podaj liczbę - 4 cyfry - w formacie XXXX:");
        }
        if (scanner.hasNextInt()) {
            int typowana = scanner.nextInt();
            scanner.nextLine();
            if (typowana == liczba) {
                wygrana = true;
                return;
            } else if (typowana < liczba) {
                System.out.println("Twoja liczba jest mniejsza od szyfru");
                liczbaZyc--;
            } else {
                System.out.println("Twoja liczba jest większa od szyfru");
                liczbaZyc--;
            }
        } else {
            String odczyt = scanner.nextLine();
            if (odczyt.length() > 0 || (odczyt.charAt(0) == '?')) {
                if (ratunek) {
                    ratunek();
                    return;
                } else {
                    System.out.println("Wykorzystałeś już podpowiedź.");
                    return;
                }
            } else {
                System.out.println("Nieprawidłowe dane. Wprowadź prawidłową liczbę lub ?");
                return;
            }
        }

    }

    private void ratunek(){
        int los = random.nextInt(4);
        System.out.print("Podpowiedź: ");
        for (int i = 0; i < 4; i++) {
            if (i == los) {
                System.out.print(cyfry[i]);
            } else {
                System.out.print("*");
            }
        }
        System.out.println();
        ratunek = false;
    }

    public void sprawdzenie(){
        if (wygrana) {
            System.out.println("$$$ Brawo! Szyfr złamany. Szyft to: " + liczba + " $$$");
            return;
        }
        if (liczbaZyc < 1) {
            System.out.println("### Koniec żyć - koniec gry. Przegrałeś ###");
            System.out.println("Szukana liczba to: " + liczba);
        }
    }

    public boolean wyjscie(){
        char litera;
        do {
            System.out.print("Czy chcesz nadal grać? (t/n):");
            litera = scanner.nextLine().toLowerCase().charAt(0);
        } while (litera != 't' && litera != 'n');
        return (litera == 'n');
    }

    public boolean koniecGry(){
        return (wygrana || (liczbaZyc < 1) );
    }
}
