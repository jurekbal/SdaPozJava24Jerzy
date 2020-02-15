package zajecia3.arrays;

//http://www.jkozak.pl/przedmioty/java/zadania3.pdf
//Zadanie 5 - Kod binarny ZM, ZU1, ZU2

//wykorzystano:
//https://pl.wikipedia.org/wiki/Kod_uzupełnień_do_dwóch
//https://eduinf.waw.pl/inf/alg/006_bin/0018.php
// https://planetcalc.com/747/ (do sprawdzenia)

import java.util.Scanner;

public class Zadanie5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj liczbę: ");
        int liczba = sc.nextInt();

        int[] kodZM = new int[32];
        int rozkladana;
        if (liczba < 0) {
            rozkladana = liczba * -1;
            kodZM[0] = 1;
        } else {
            rozkladana = liczba;
            kodZM[0] = 0;
        }

        int poz;
        for (poz = 31; poz > 0; poz--) {
            kodZM[poz] = rozkladana % 2;
            rozkladana /= 2;
            if (rozkladana == 0) {
                break; // zachowujemy pozycje najbardziej znaczącego bitu
            }
        }

        // druk liczby w kodzie ZM
        System.out.print("Liczba " + liczba + " binarnie (ZM): " + kodZM[0] + ".");
        for (int i = poz; i < kodZM.length; i++) { //drukowanie bez zer przewodnich, od pozycji wskazanej przez poz
            System.out.print(kodZM[i]);
        }
        System.out.println();

        // obliczenia tablicy w kodzie ZU1;
        int[] kodZU1 = new int[32];
        kodZU1[0] = kodZM[0];
        for (int i = 1; i < kodZM.length; i++) {
            if (kodZM[0] == 0) {
                kodZU1[i] = kodZM[i];
            } else {
                kodZU1[i] = (kodZM[i] == 1) ? 0 : 1;
            }
        }

        //druk tablicy w kodzie ZU1
        System.out.print("Liczba " + liczba + " binarnie (ZU1): " + kodZU1[0] + ".");
        for (int i = 1; i < kodZU1.length; i++) { //drukowanie całości, bo przy liczbie ujemnej kod jest odwrócony
            System.out.print(kodZU1[i]);
        }
        System.out.println();

        //obliczenia tablicy w kodzie ZU2
        int[] kodZU2 = new int[32];
        for (int i = 0; i < kodZM.length; i++) {
            kodZU2[i] = kodZM[i];
        }
        // jeśłi liczba jest ujemna to wyznaczamy liczbę przeciwną ZU2
        if (kodZM[0] == 1) {
            boolean jestJedynka = false; //napotykamy jedynkę idąc od prawej
            for (int i = 31; i > 0; i--) {
                if (jestJedynka) {
                    kodZU2[i] = (kodZU2[i] == 1) ? 0: 1;
                }
                if (!jestJedynka && kodZU2[i] == 1) {
                    jestJedynka = true;
                }
            }
        }

        // wydruk tablicy w kodzie ZU2
        System.out.print("Liczba " + liczba + " binarnie (ZU2): " + kodZU2[0] + ".");
        for (int i = 1; i < kodZU2.length; i++) { //drukowanie całości, bo tak
            System.out.print(kodZU2[i]);
        }
        System.out.println();
    }

}

