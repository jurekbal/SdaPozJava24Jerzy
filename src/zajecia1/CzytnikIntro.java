package zajecia1;

import java.util.Scanner;

public class CzytnikIntro {
    public static void main(String[] args){

        // aby czytac dane użytkownika musimy utowrzyć obiekt Scanner j/n
        Scanner czytnik = new Scanner(System.in);
        // czytnik to zmienna/obiekt typu Scanner

        double wiek = 0;
        String imie;

        System.out.println("Podaj swoje imie:");
        imie = czytnik.nextLine();
        System.out.println("Podaj swój wiek:");
        wiek = czytnik.nextDouble();

        System.out.println("Witaj " + imie + "! Masz " + wiek + " lat.");

    }
}
