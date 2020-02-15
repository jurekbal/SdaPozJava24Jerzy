package zajecia3.arrays;

import java.util.Scanner;

public class ArrayIntro {
    public static void main(String[] args) {

        String[] imiona = {"Ala", "Piotrek", "Wacek", "Tomek", "Eliza"};

        for (int i = 0; i < imiona.length; i++){
            System.out.println("Imię nr. " + i + " to " + imiona[i]);
        }

        // dynamiczne tworzenie tablic
        System.out.print("Podaj rozmiar tablicy: ");
        Scanner sc = new Scanner(System.in);
        int rozmiar = sc.nextInt();

        int[] dynamicznaTablica = new int[rozmiar];

        System.out.println("Rozmiar dynamicznej tablicy: " + dynamicznaTablica.length);

    }
}
