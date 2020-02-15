package zajecia4.funkcje;

//http://www.jkozak.pl/przedmioty/java/zadania4.pdf
// Zad. 6 - kodowanie szyfrem Cezara

import java.util.Scanner;

public class Zadanie6 {

    static String szyfruj(String rawString, int shift){
        String zakodowany = "";

        // zakres a-z: 97-122 + spacja = 32
        // spacje olewamy na razie; 26 znaków
        // zredukowany_zakres = zakres mod 26;
        // nowyznak = znak + zredukowany_zakres
        // jeżęli nie w zakresie 97..122 to +- 26
        int zredukowanePrzesuniecie = shift % 26;

        for (int i = 0; i < rawString.length(); i++) {
            char c = rawString.charAt(i);
            if (c == ' ') {
                zakodowany+= ' '; // spacje przepisujemy - uproszcenie
            }
            if (c >= 'a' && c <= 'z' ){
                 if ((c + zredukowanePrzesuniecie) < 97) {
                    zakodowany+= (char) (c + zredukowanePrzesuniecie + 26);
                } else if ((c + zredukowanePrzesuniecie) > 122) {
                    zakodowany+= (char) (c + zredukowanePrzesuniecie - 26);
                } else {
                    zakodowany+= (char) (c + zredukowanePrzesuniecie);
                }
            }
        }
        return zakodowany;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj tekst do zaszyfrowania (tylko małe litery): ");
        String tekst = sc.nextLine();
        System.out.print("Podaj przesunięcie: ");
        int przesuniecie = sc.nextInt();
        System.out.print("Zaszyfrowany tekst: " + szyfruj(tekst, przesuniecie));
    }
}
