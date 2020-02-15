package zajecia3.arrays;

// faktycznie robione na zajeciach 4
// zadania3.pdf - zadanie 3 (tablice)

import java.util.Random;

public class Zadanie3 {
    public static void main(String[] args) {
        Random random = new Random();

        int[][] macierz = new int[5][5];
        int[] minima = new int[5];
        int[] maksima = new int[5];

        // Wypełninienie tablicy, obliczanie minim i maksim
        for (int i = 0; i < macierz.length; i++) {
            for (int j = 0; j < macierz[0].length; j++) {
                macierz[i][j] = random.nextInt(11) - 5;
                if (i == 0) { // inicjalizacja minima i maksima - tylko dla pierwszego wiersza
                    minima[j] = macierz[i][j];
                    maksima[j] = macierz[i][j];
                }
                else {
                    if (minima[j] > macierz[i][j]) {
                        minima[j] = macierz[i][j];
                    }
                    if (maksima[j] < macierz[i][j]) {
                        maksima[j] = macierz[i][j];
                    }
                }
            }
        }

        // Drukowanie wyników

        // Drukowanie macierzy
        for (int i = 0; i < macierz.length; i++) {
            for (int j = 0; j < macierz[0].length; j++) {
                System.out.print(macierz[i][j] + " ");
            }
            System.out.println();
        }
        // drukowanie minim i maksim
        System.out.println("Minima:");
        // for each!
        // w for each tracimy informację o indeksie
        for (int min : minima) {
            System.out.print(min + " ");
        }
        System.out.println();
        System.out.println("Maksima:");
        for (int maks: maksima) {
            System.out.print(maks + " ");
        }
    }
}
