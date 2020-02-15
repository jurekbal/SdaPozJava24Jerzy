package zajecia3.arrays;

// faktycznie robione na zajęciach 4

import java.util.Random;
import java.util.Scanner;

public class Zadanie2 {
    // zadania3.pdf - zadanie 2 (tablice)
    // modyfikacja zadania: wielkośc tablicy podana przez usera
    // liczby losowe


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("Podaj ilość liczb (rozmiar tablicy): ");
        int rozmiar = sc.nextInt();

        int[] liczby = new int[rozmiar];

        for (int i = 0; i < liczby.length; i++){
            liczby[i] = rand.nextInt(10) + 1; // bound: 10 = zakres 0..9
        }

        int[] wystapienia = new int[11]; // nie uzywamy  wystapienia[0] - jest czytelniej
        // zerować ??? - nie trzeba!!!

        for (int i = 0; i < liczby.length; i++) {
            wystapienia[liczby[i]]++;
        }

        System.out.println("Zawartość tablicy liczb: ");
        for (int i = 0; i < liczby.length; i++) {
            System.out.print(liczby[i] + ", ");
        }
        System.out.print('\b');
        System.out.print('\b');
        System.out.println(';');

        for (int i = 1; i < 11; i++) {
            System.out.println(i + " - " + wystapienia[i]);
        }


    }
}
