package zajecia4.funkcje;

public class Intro {

    // prosta f. nr 1 pobierająca dwa argumenty i zwracająca wynik
    static int dodaj(int a, int b){
        return a + b;
    }

    // funkcja nr 2, która nic nie zwraca, ale wypisuje zawartość tablicy
    static void printArray(String[] array){
        System.out.print("[ ");
        for (String s : array) {
            System.out.print(s+", ");
        }
        // kasujemy ostatni przecinek
        // na przyszłość: eleganckie rozwiązanie z uzyciem StringBuilder
        System.out.print('\b');
        System.out.print('\b');

        System.out.println(" ]");
    }

    // funkcja 3
    static int fibo(int n){
        int fib1 = 1;
        int fib2 = 1;
        int suma = 0;
        for (int i = 3; i < n; i++) {
            suma = fib1 + fib2;
            fib1 = fib2;
            fib2 = suma;
        }
        return suma;
    }

    public static void main(String[] args) {
        // funkcja 1
        int pierwszaLiczba = 10;
        int drugaLiczba = 20;
        int wynik = dodaj(pierwszaLiczba, drugaLiczba);
        System.out.println("Wynik: "+wynik);

        // funkcja 2
        String[] imiona = {"Adam", "Marcin", "Kasia"};
        printArray(imiona);

        // f3
        int argN = 20;
        System.out.println("Fibo(" + argN + "): " + fibo(argN));
    }
}
