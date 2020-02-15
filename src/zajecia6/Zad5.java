package zajecia6;

import java.util.Scanner;

public class Zad5 {
    // Zad. 5 z pliku Zadania_tabs - zbiór (zaj6-15-lut).pdf

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Podaj liczbę:");
        int liczba = sc.nextInt();
        int sumaCyfr = 0;

        int dzielona = liczba;
        while (dzielona > 0) {
            sumaCyfr += dzielona % 10;
            dzielona /= 10;
        }

        System.out.println("Suma cyfr liczby: " + liczba + " wynosi: " + sumaCyfr);

        //        String liczbaStr = sc.nextLine();
//        liczbaStr.split();
    }
}
