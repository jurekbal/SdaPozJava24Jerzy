package zajecia4.funkcje;

//http://www.jkozak.pl/przedmioty/java/zadania4.pdf
// czy palindrom (nie ignoruje spacji)

import java.util.Scanner;

public class Zadanie3 {


    static boolean isPalindrome(String str){
        /**  nie ignoruje spacji
        *    moja wersja        */
        boolean itIs = true;
        for (int i = 0; i < str.length()/2; i++) {
            if (str.charAt(i) != str.charAt(str.length()-i-1)) {
                itIs = false;
            }
        }
        return itIs;
    }

    // wersja z zajec
    static boolean isPalindrome2(String str){
        /** wersja z zajec */
        for (int i = 0; i < str.length()/2; i++) {
            if (str.charAt(i) != str.charAt(str.length()-i-1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj napis. Sprawdzimy czy to palindrom: ");
        String napis = sc.nextLine();
        if (isPalindrome(napis)) {
            System.out.println("To palindrom!");
        }
        else {
            System.out.println("Żaden tam palindrom");
        }
        if (isPalindrome2(napis)) {
            System.out.println("2. To palindrom!");
        }
        else {
            System.out.println("2. Żaden tam palindrom");
        }
    }


}
