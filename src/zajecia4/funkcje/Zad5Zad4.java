package zajecia4.funkcje;

// http://www.jkozak.pl/przedmioty/java/zadania5.pdf
// Zadanie 4 - flip case
// bez obsługi polskich znaków

import java.util.Scanner;

public class Zad5Zad4 {

    static String flipCase(String text){
        String flip = "";
        for (int i = 0; i < text.length(); i++) {
            char c;
            if (text.charAt(i) >=65 && text.charAt(i) <= 90) {
                c = (char) (text.charAt(i) + 32);
                flip += c;
            }
            else if (text.charAt(i) >=97 && text.charAt(i) <= 122) {
                c = (char) (text.charAt(i) - 32);
                flip += c;
            } else {
                flip += text.charAt(i);
            }
        }
        return flip;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj tekst:");
        String t = sc.nextLine();

        System.out.println("Flipcased text:");
        System.out.println(flipCase(t));
    }

}
