package zajecia3;

//http://www.jkozak.pl/przedmioty/java/zadania5.pdf
//Zadanie 2 - Ciąg Fibonancciego
// wersja z zajęć - tylko iteracyjna

import java.util.Scanner;

public class Fibo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Podaj dlugość ciągu Fibonacciego: ");
        int n = sc.nextInt();

        int fib1 = 1;
        int fib2 = 1;
        int fib3;


        int i = 3;
        System.out.println("fib(1)=" + fib1);
        System.out.println("fib(2)=" + fib2);
        fib3 = fib1 + fib2;
        while (i <= n) {
            System.out.println("fib(" + i + ")=" + fib3);
            fib1 = fib2;
            fib2 = fib3;
            fib3 = fib1 + fib2;
            i++;
        }

        //implementacja z zajęć - prostrza
        System.out.println();
        System.out.println("Implementacja z zajęć: ");
        fib1 = 1;
        fib2 = 1;
        System.out.println("fib(1)=" + fib1);
        System.out.println("fib(2)=" + fib2);
        for ( i = 3; i <= n; i++) {
            fib3 = fib1 + fib2; //obliczanie kolejnego wyrazu
            System.out.println("fib(" + i + ")=" + fib3);
            fib1 = fib2;
            fib2 = fib3;
        }


    }
}
