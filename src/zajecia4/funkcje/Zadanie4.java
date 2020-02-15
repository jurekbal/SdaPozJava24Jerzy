package zajecia4.funkcje;

//http://www.jkozak.pl/przedmioty/java/zadania4.pdf
// Zad. 4 - suma syfr w tekście

import java.util.Scanner;

public class Zadanie4 {

    static int sumaCyfr(String tekst){
        int suma = 0;
        char[] tekstarr = tekst.toCharArray();
        for (char c : tekstarr) {
            if (c > 48 && c < 58) { // zera (48) nie liczymy, bo po co
                suma+= c - 48;
            }
        }
        return suma;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Wpisz zdanie:");
        String zdanie = sc.nextLine();
        System.out.println("W tekście suma syfr wynosi: " + sumaCyfr(zdanie));
    }

}
