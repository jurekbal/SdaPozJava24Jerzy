package zajecia4.funkcje;

//http://www.jkozak.pl/przedmioty/java/zadania4.pdf
// Odwróć napis

import java.util.Scanner;

public class Zadanie2 {

    // funkcja moja
    static String odwrocNapis(String str){
        char[] chararr = str.toCharArray();
        char[] chararr2 = str.toCharArray();
        //char[] chararr2 = chararr; // nie może być bo to ta sama tablica!
        for (int i = 0; i < chararr.length; i++) {
            chararr2[i] = chararr[chararr.length - i - 1];
        }
        return new String(chararr2);
    }

    // po sugestii z zajeć - bez toCharArray, prostrza
    static String odwrocNapis2(String str) {
        String odwrotny = "";
        for (int i = 0; i < str.length(); i++) {
            odwrotny += str.charAt(str.length() - i - 1);
        }
        return odwrotny;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj napis do odwrócenia:");
        String napis = sc.nextLine();
        System.out.println(odwrocNapis(napis));
        System.out.println(odwrocNapis2(napis));
    }
}


