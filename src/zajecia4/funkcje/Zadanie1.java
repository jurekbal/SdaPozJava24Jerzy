package zajecia4.funkcje;

//http://www.jkozak.pl/przedmioty/java/zadania4.pdf
// policz ilość wystąpień ostatniej litery w całym łańcuchu
// modyfikacja: z użyciem funkcji;

import java.util.Scanner;

public class Zadanie1 {

    static int zliczOstatniZnak(String str){
        str = str.toLowerCase();  // innowacja poza warunkami zadania
        char[] chararr = str.toCharArray();
        int counter = 0;
        for (char c : chararr) {
           if (c == str.charAt(str.length()-1)) {
               counter++;
           }
        }
        return counter;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Podaj stringa:");
        String napis = sc.nextLine();

        System.out.println("Ostatnia litera wystąpiła " + zliczOstatniZnak(napis) + " raz(y).");
    }
}
