package zajecia4.funkcje;

//http://www.jkozak.pl/przedmioty/java/zadania5.pdf
//Zadanie 3 - pozycja znaku, funkcje

import java.util.Scanner;

public class Zad5Zad3 {

    static int strpos(String text, char z){
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == z) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj tekst:");
        String t = sc.nextLine();
        System.out.println("Podaj znak:");
        char znak = sc.nextLine().charAt(0);
        int pozycja = strpos(t, znak);
        if (pozycja != -1){
            System.out.println("Znak znajduje się na pozycji: " + pozycja);
        }
        else{
            System.out.println("Nie ma takiego znaku w tekście.");
        }
    }

}
