package zajecia6;

import java.util.Scanner;

public class Zad5 {
    // Zad. 5 z pliku Zadania_tabs - zbiór (zaj6-15-lut).pdf

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Podaj liczbę:");
        int liczba = Integer.valueOf(sc.nextLine());

        int sumaCyfr = 0;

        int dzielona = liczba;
        while (dzielona > 0) {
            sumaCyfr += dzielona % 10;
            dzielona /= 10;
        }

        System.out.println("Suma cyfr liczby: " + liczba + " wynosi: " + sumaCyfr);

        //wersja z liczbą jako String
        System.out.print("Podaj liczbę jeszcze raz: ");
        String liczbaStr = sc.nextLine();
        //String liczbaStr = "567";

        sumaCyfr = 0;
        for (int i = 0; i < liczbaStr.length(); i++) {
            char c = liczbaStr.charAt(i);
            sumaCyfr += Integer.valueOf(String.valueOf(c));
        }

        System.out.println("Suma cyfr liczby: " + liczbaStr + " wynosi: " + sumaCyfr);

        //        liczbaStr.split();
    }
}
