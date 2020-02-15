package zajecia4.funkcje;

//http://www.jkozak.pl/przedmioty/java/zadania4.pdf
// Zad. 5 zliczanie nawiasów, kontrola

import java.util.Scanner;

public class Zadanie5 {

    static boolean kontrolaSparowania(String wyrazenie){

        int licznikNawiasow = 0;

        for (int i = 0; i < wyrazenie.length() ; i++) {
            if (wyrazenie.charAt(i) == '(') {
                licznikNawiasow++;
            }
            if (wyrazenie.charAt(i) == ')') {
                licznikNawiasow--;
            }
            if (licznikNawiasow < 0) {
                return false;
            }
        }

        if (licznikNawiasow == 0){
            return true;
        }
        else {
            return false;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Wpisz wyrażenie:");
        String wyrazenie = sc.nextLine();
        System.out.println("Wynik:");
        if (kontrolaSparowania(wyrazenie)) {
            System.out.printf("OK");
        }
        else {
            System.out.println("Błędne sparowanie nawiasów");
        }
    }
}
