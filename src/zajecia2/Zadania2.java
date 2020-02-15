package zajecia2;

import java.util.Random;
import java.util.Scanner;

// zadania2.pdf - Zajecia 2 – instrukcje warunkowe, petle
// podobno ze strony jkozak

public class Zadania2 {
    public static void main(String[] args) {

        // 1 - nieparzyste od 1 do podanej liczby
        // 2 - suma ciągu liczb od A do B (A<B)
        // 3 - potegi dwójki do wskazanej liczby
        // 103 - inna implementacja zad 3
        // 4 - wczytywanie liczb dopóki nie 0, suma wczytanych
        // 5 - z podanych liczb wypisać sumę maks i min oraz średnią min i max
        // 6 - losowa 1..100 - zgadywanie mniejsza/większa
        // 7 - rysowanie kwadratu
        // 8 - rysowanie choinki
        // 9 - sumowanie cyfr liczby
        // 10 - dzielniki liczby
        // 11 - spr czy liczba pierwza

        int nrZadania = 103;

        Scanner sc = new Scanner(System.in);

        switch (nrZadania) {
            case 1: {
                System.out.print("Zadanie 1. Podaj liczbę: ");
                int liczba = sc.nextInt();
                for (int i = 1; i <= liczba; i += 2) {
                    System.out.println(i);
                }
                break;
            }
            case 2: {
                System.out.print("Zadanie 2. Podaj mniejszą liczbę: ");
                int A = sc.nextInt();
                System.out.print("Podaj większą liczbę: ");
                int B = sc.nextInt();
                if (!(A < B)) {
                    System.out.println("Pierwsza liczba nie jest mniejsza od drugiej! Koniec.");
                    break;
                }
                // implemantacja z wyk. pętli while
                int element = A;
                int suma = 0;
                while (element <= B) {
                    suma += element;
                    element++;
                }
                System.out.println("Suma ciągu (while): " + suma);

                // implementacja - pętla do..while
                element = A;
                suma = 0;
                do {
                    suma += element;
                    element++;
                } while (element <= B);
                System.out.println("Suma ciągu (do..while): " + suma);

                // implementacja - pętla for
                suma = 0;
                for (element = A; element <= B; element++) { // czy użycie wcześniej zdefiniowanej zmiennej jako iteratora jest prawidłowe?
                    suma += element;
                }
                System.out.println("Suma ciągu (for): " + suma);

                break;
            }
            case 3: {
                System.out.print("Zadanie 3. Podaj liczbę: ");
                int liczba = sc.nextInt();
                int suma = 0;
                for (int n = 0; suma <= liczba; n++) {
                    if (n == 0) {
                        suma = 1;
                    }
                    else {
                        suma = suma * 2;
                    }
                    if (suma > liczba) {
                        break;
                    }
                    System.out.println(suma);
                }
                break;
            }
            case 103: {
                // ciekawa implementacja z zajęć.
                System.out.print("Zadanie 103 (metoda 2). Podaj liczbę: ");
                int liczba = sc.nextInt();
                for (int i = 1; i<=liczba; i*= 2){
                    System.out.print(i + ", ");
                }

                break;
            }
            case 4: {
                int suma = 0;
                int liczba;
                System.out.println("Zadanie 4.");
                do {
                    System.out.print("Podaj liczbę (0 = koniec): ");
                    liczba = sc.nextInt();
                    suma += liczba;
                } while (liczba != 0);
                System.out.println("Suma wpisanych liczb: " + suma);
                break;
            }
            case 5: {

                boolean pusty = true; // ciąg jest pusty (pierwsza podana wartość=0), inicjalizacja
                int liczba;
                double suma = 0.0;
                int min = 0;
                int maks = 0;
                System.out.println("Zadanie 5.");
                do {
                    System.out.print("Podaj liczbę (0 = koniec): ");
                    liczba = sc.nextInt();
                    // inicjalizacja, potrzebne np. przy 1 elemencie
                    if (pusty) {
                        min = liczba;
                        maks = liczba;
                    }
                    if (liczba != 0) {
                        pusty = false;
                        suma += liczba;
                        if (liczba > maks)
                            maks = liczba;
                        if (liczba < min)
                            min = liczba;
                    }

                } while (liczba != 0);
                if (!pusty) {
                    System.out.println("Suma min+maks: " + (min + maks));
                    System.out.println("Średnia min i max: " + ((min + maks) / 2.0));
                } else
                    System.out.println("Brak elementów w ciągu.");

                break;
            }
            case 6: {
                Random r = new Random();
                int szukana = r.nextInt(100) + 1;
                int typ;
                System.out.println("Zadanie 6. Znajdź liczbę w przedziale 1..100");

                do {
                    System.out.print("Podaj twój typ: ");
                    typ = sc.nextInt();
                    if (typ == szukana) {
                        System.out.println("Brawo! Znalazłeś szukaną liczbę!");
                        break;
                    } else if (typ > szukana) System.out.println("Szukana liczba jest mniejsza.");
                    else System.out.println("Szukana liczba jest większa.");
                } while (true);
                break;
            }
            case 7: {
                System.out.print("Zadanie 7. Podaj znak wypełnienia: ");
                char znak = sc.next().charAt(0);  //tak wczytujemy char - przez wyciągnięcie pierwszego znaku ze stringa
                System.out.print("Podaj pozycję x początku rysowania: ");
                int x = sc.nextInt();
                System.out.print("Podaj pozycję y początku rysowania: ");
                int y = sc.nextInt();
                System.out.print("Podaj szerokość prostokąta (a): ");
                int a = sc.nextInt();
                System.out.print("Podaj wysokość prostokąta (b): ");
                int b = sc.nextInt();
                for (int j = 1; j <= b+y-1; j++ ) {
                    for (int i = 1; i <= a+x-1; i++){
                        if ((i < x) || (j < y)) {
                            System.out.print("-");
                        }
                        else {
                            System.out.print(znak);
                        }
                    }
                    System.out.println();
                }
                break;
            }
            case 8: {
                System.out.print("Zadanie 8. Podaj wysokość choinki: ");
                int wys = sc.nextInt();
                for (int wiersz = 1; wiersz <= wys; wiersz++){
                    for (int i = 1; i<= wys - wiersz; i++){
                        System.out.print(" ");
                    }
                    for (int i = 1; i<= (2*wiersz-1); i++){
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;
            }
            case 9: {
                System.out.print("Zadanie 9. Podaj liczbę całkowitą: ");
                long liczba = sc.nextInt();
                int sumaCyfr = 0;
                int sumaCyfrNieparzystych = 0;
                int sumaCyfrParzystych = 0;
                int iloscCNP = 0;
                int iloscCP = 0;
                long cyfra;
                do {
                    cyfra = liczba % 10;
                    sumaCyfr+= cyfra;
                    if (cyfra != 0) {
                        if ((cyfra % 2) == 0) {
                            sumaCyfrParzystych+= cyfra;
                            iloscCP++;
                        }
                        else { //jest nieparzysta
                            sumaCyfrNieparzystych+= cyfra;
                            iloscCNP++;
                        }
                        liczba/= 10;
                    }
                } while (liczba != 0);
                System.out.println("Suma cyfr: " + sumaCyfr);
                if (iloscCP == 0 || iloscCNP == 0) {
                    System.out.println("Brak cyfr parzystych lub nieparzystych. Nie można obliczyć średniej.");
                }
                else {
                    System.out.println("Stosunek średniej arytmetycznej cyfr parzystych do średniej arytmetycznej cyfr nieparzystych: " +
                            ( ((double)sumaCyfrParzystych/(double)iloscCP) / ((double)sumaCyfrNieparzystych/(double)iloscCNP)) );
                }

                break;
            }
            case 10: {
                System.out.print("Zadanie 10. Podaj liczbę całkowitą: ");
                int liczba = sc.nextInt();
                for (int i = 1; i <= liczba; i++){
                    if (liczba%i == 0) {
                        System.out.print(i + ", ");
                    }
                }
                break;
            }
            case 11: {
                System.out.print("Zadanie 11. Podaj liczbę całkowitą > 1: ");
                int liczba = sc.nextInt();
                boolean pierwsza = true;
                for (int i = 2; i < liczba; i++){
                    if (liczba%i == 0) {
                        pierwsza = false;
                        break;
                    }
                }
                if (pierwsza) {
                    System.out.print("Jest liczbą pierwszą.");
                }
                else {
                    System.out.print("Nie jest liczbą pierwszą.");
                }
                break;
            }
        }
    }

}
