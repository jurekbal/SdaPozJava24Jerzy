package zajecia6;

import java.util.Random;
import java.util.Scanner;

public class Lotto {
    // Zad. 1 z pliku Zadania_tabs - zbiór (zaj6-15-lut).pdf

    public static void main(String[] args) {

        int[] podane = new int[6];
        int[] wylosowane = new int[6];

        Random rd = new Random();
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 6; i++) {

            //pobranie liczb ze sprawdzeniem czy nie występują
            boolean liczbaNieprawidlowa = false;
            do {
                System.out.print("Podaj liczbę nr " + (i+1) + " z zakresu 1-49:");
                podane[i] = sc.nextInt();

                // spradzenie zakresu
                if (podane[i] < 1 || podane[i] > 49) {
                    System.out.println("Nieprawidłowa liczba - dozwolony zakres 1..49");
                    liczbaNieprawidlowa = true;
                    continue;
                }

                for (int j = 0; j < i; j++) {
                    if (podane[i] == podane[j]) {
                        liczbaNieprawidlowa = true;
                        System.out.println("Już podałeś tą liczbę!");
                        break;
                    }
                    liczbaNieprawidlowa = false;
                }


            } while (liczbaNieprawidlowa);

            // losowanie, ze sprawdzaniem duplikatów.
            liczbaNieprawidlowa = true;
            while (liczbaNieprawidlowa) {
                wylosowane[i] = rd.nextInt(49) + 1;
                liczbaNieprawidlowa = false;
                for (int j = 0; j < i; j++) {
                    if (wylosowane[i] == wylosowane[j]) {
                        liczbaNieprawidlowa = true;
                        break;
                    }
                }
            }

        }

        System.out.println("Wytypowane liczby:");
        for (int i = 0; i < 6; i++) {
            System.out.print(podane[i] + " ");
        }
        System.out.println();
        System.out.println("Wylosowane liczby:");
        for (int i = 0; i < 6; i++) {
            System.out.print(wylosowane[i] + " ");
        }

        int trafionych = 0;
        for (int p : podane) {
            for (int w: wylosowane) {
                if (w == p) {
                    trafionych++;
                }
            }
        }
        System.out.println("Trafiono " + trafionych + " z 6 liczb");


    }
}
