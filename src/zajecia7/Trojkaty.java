package zajecia7;

import java.util.Scanner;

// Zadania-tabs*.pdf zad 13
public class Trojkaty {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj ilość wierszy:");
        int odczyt = Integer.parseInt(sc.nextLine());

        System.out.println("(a)");
        trojkatA(odczyt);
        System.out.println("(b)");
        trojkatB(odczyt);
        System.out.println("(c)");
        trojkatC(odczyt);
        System.out.println("(d)");
        trojkatD(odczyt);
    }

    private static void trojkatA(int liczbaWierszy){
        for (int i = 1; i <= liczbaWierszy; i++) {
            for (int j = 1; j <= liczbaWierszy ; j++) {
                if (j <= i) {
                    System.out.print("* ");
                } else {
                    System.out.print(' ');
                }
            }
            System.out.println();
        }
    }

    private static void trojkatB(int liczbaWierszy){
        for (int i = 1; i <= liczbaWierszy; i++) {
            for (int j = liczbaWierszy; j >= 1 ; j--) {
                if (j >= i) {
                    System.out.print("* ");
                } else {
                    System.out.print(' ');
                }
            }
            System.out.println();
        }
    }

    private static void trojkatC(int liczbaWierszy){
        for (int i = 1; i <= liczbaWierszy; i++) {
            for (int j = 1; j <= liczbaWierszy ; j++) {
                if (j >= i) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    private static void trojkatD(int liczbaWierszy){
        for (int i = 1; i <= liczbaWierszy; i++) {
            for (int j = liczbaWierszy; j >= 1 ; j--) {
                if (j > i) {
                    System.out.print("  ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }



}
