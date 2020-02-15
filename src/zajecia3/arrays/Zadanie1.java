package zajecia3.arrays;

import java.util.Scanner;
// zadania3.pdf - zadanie 1 (tablice)

public class Zadanie1 {
    public static void main(String[] args) {

        System.out.print("Podaj rozmiar tablicy: ");
        Scanner sc = new Scanner(System.in);
        int rozmiar = sc.nextInt();

        int[] liczby = new int[rozmiar];
        /*
        liczby[0] = 9;
        liczby[1] = 2;
        liczby[2] = 5;
        liczby[3] = -3;
        liczby[4] = -8;
        liczby[5] = 9;
        liczby[6] = 0;
        liczby[7] = 1;
        liczby[8] = 7;
        liczby[9] = -3;
        */

        for (int i = 0; i < liczby.length; i++){
            System.out.print("Podaj wartość dla indeksu " + i +"= ");
            liczby[i] = sc.nextInt();
        }

        for (int i = 0; i < liczby.length; i++) {
            System.out.println(i + "=" + liczby[i]);
        }
        // array.length - bez nawiasów ();

        // wyznaczanie min i maks
        int maks = liczby[0];
        int min = liczby[0];
        for (int i = 1; i < liczby.length; i++) {
            if (liczby[i] > maks) {
                maks = liczby[i];
            }
            if (liczby[i] < min) {
                min = liczby[i];
            }
        }
        System.out.println("Najmniejszy element tablicy: " + min);
        System.out.println("Największy element tablicy: " + maks);

        // wyznaczanie średniej
        double suma = 0;
        for (int i = 0; i < liczby.length; i++) {
            suma += liczby[i];
        }
        double srednia = (suma / liczby.length);
        System.out.println("Srednia arytmetyczna el. tablicy: " + srednia);

        // wyznaczanie liczby el. mniejszych i większych od średniej
        int mniejszych = 0;
        int wiekszych = 0;
        for (int i = 0; i < liczby.length; i++) {
            if (liczby[i] < srednia) {
                mniejszych++;
            }
            if (liczby[i] > srednia) {
                wiekszych++;
            }
        }
        System.out.println("Mnijeszych od średniej: " + mniejszych);
        System.out.println("Większych od średniej: " + wiekszych);

        /*  // wersja z zajęc z użyciem continue
        int wiekszych = 0;
        for (int i = 0; i < liczby.length; i++) {
            if (maks >= liczby[i]){
                continue;
            }
            maks = liczby[i];
        }
        */

        //wypis od tyłu
        for (int i = liczby.length - 1; i >= 0; i--) {
            System.out.println(i + "= " + liczby[i]);

        }

    }
}