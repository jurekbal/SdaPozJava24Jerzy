package zajecia7.zadaniaDomowe;

import java.util.Scanner;

// wersja 1:
// wisielec metodą 'wszystko w main'
public class WisielecVer1 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int liczbaZyc;
        String slowo;
        boolean[] odgadnieta = new boolean[100];
        String odczyt;
        char litera;


        do {
            liczbaZyc = 5;
            System.out.println("Gra wisielec - witamy");
            System.out.println("Podaj hasło dla przeciwnika:");
            slowo = scanner.nextLine().toLowerCase();
            for (int i = 0; i < 100; i++) {
                System.out.println();
            }

            while (liczbaZyc > 0) {
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


                System.out.print("Podaj jeden znak: ");
                odczyt = scanner.nextLine();
                if (odczyt.length() > 1) {
                    System.out.println("Podałeś za dużo znaków. Tracisz życie!");
                    liczbaZyc--;
                    continue;
                } else if (odczyt.isEmpty()) {
                    System.out.println("Nie podałeś litery. Tracisz życie");
                    liczbaZyc--;
                    continue;
                } else {
                    litera = odczyt.toLowerCase().charAt(0);
                }

                // spr czy jest w slowie
                boolean trafiony = false;
                boolean juzBylTrafiony = false;
                boolean wygrana = true;
                for (int i = 0; i < slowo.length(); i++) {
                    if (slowo.charAt(i) == litera) {
                        if (odgadnieta[i] == true) {
                            juzBylTrafiony = true;
                        }
                        odgadnieta[i] = true;
                        trafiony = true;
                    }
                    if (!odgadnieta[i]) {
                        wygrana = false;
                    }
                }
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
                if (wygrana) {
                    System.out.println("Brawo! Wygrałeś");
                    System.out.println("Szukane słowo to: " + slowo);
                    break;
                } else {
                    System.out.println("Przegrałeś! Spróbuj ponownie");
                    break;
                }
            }

            do {
                System.out.println("Czy chcesz nadal grać? (t/n):");
                litera = scanner.nextLine().toLowerCase().charAt(0);
            } while (litera != 't' && litera != 'n');

        } while (litera != 'n');

        System.out.println("Do widzenia.");
    }

}
