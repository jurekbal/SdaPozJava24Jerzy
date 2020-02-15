package zajecia2;

import java.util.Scanner;

public class Kalkulator {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Witaj w kalkulatorze.");
        System.out.print("Podaj pierewszą liczbę: ");
        double a = s.nextDouble();
        System.out.print("Podaj znak działania (+ - * /): ");
        String z = s.next();
        boolean blad = false;
        if (!(z.equals("+") || z.equals("-") || z.equals("*") || z.equals("/"))) {
            System.out.println("Nie jest OK... Sayonara.");
            blad = true;
        }

        double wynik = 0;

        if (!blad) {
            System.out.print("Podaj drugą liczbę: ");
            double b = s.nextDouble();
            switch (z) {
                case "+":
                    wynik = a + b;
                    break;
                case "-":
                    wynik = a - b;
                    break;
                case "*":
                    wynik = a * b;
                    break;
                case "/": {
                    if (b != 0) wynik = a / b;
                    else {
                        System.out.println("Błąd. Próba dzielenia przez zero.");
                        blad = true;
                    }
                    break;
                }
            }
        }
        if (!blad) {
            System.out.println("Wynik: " + wynik);
        } else {
            System.out.println("Wykryto błędy. Wynik nie został obliczony");
        }


    }
}
