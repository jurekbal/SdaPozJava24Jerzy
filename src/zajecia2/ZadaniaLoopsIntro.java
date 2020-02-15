package zajecia2;

import java.util.Scanner;

public class ZadaniaLoopsIntro {
    public static void main(String[] args){

        // Zadania 0 i 1 to dwa warianty zadania 1
        // 0 - parzyste od 0 do 100
        // 1 - nieparzyste od 200 do 300
        // 2 - podzielne przez 7 od 1 do 1500
        // 3 - suma liczb od 1 do 100
        // 101 - wariant 1; nieparzyste od 100 do 0
        // 4 - zliczanie długości łańcucha znakowego z białymi znakami
        // 104 - wariant 4 - bez białych znaków (bez spacji);
        // 1042 - jak 104, ale bez uzycia tablicy;
        // 5 - sumowanie liczb nieparzystych od 1..100 przy pomocy do while
        // 6 - wyswietlic duże litery alfabetu od A-Z i od Z-A przy użyciu for, while, do
        // 7 - 100.300 - wypisać + wypisać czy parzysta, czy nieparzysta używając operatora trójargumentowego

        // Wpisz nr zadania z zadania-java-wstep.pdf
        int nrZadania = 1042;

        Scanner czytnik = new Scanner(System.in);

        switch (nrZadania) {
            case 0: {
                int i = 0;
                while (i <= 100) {
                    if ((i % 2 == 0) && (i != 0))
                        System.out.print(i + " ");
                    i++;
                }
                break;
            }
            case 1: {
                for(int i=201; i <= 299; i += 2){
                    System.out.print(i + " ");
                }
                break;
            }
            case 2: {
                for(int i = 1; i <= 1500; i++) {
                    if ((i % 7) == 0)
                        System.out.print(i + " ");
                }
                break;
            }
            case 3: {
                int suma = 0;
                for (int i = 1; i <= 100; i++){
                    suma += i;
                }
                System.out.println("Suma liczb od 1 do 100 wynosi " + suma);
                break;
            }
            case 101: {
                for(int i = 99; i > 0; i-=2){
                    System.out.print(i + " ");
                }
                break;
            }
            case 4: {
                System.out.print("Podaj dowolny napis: ");
                String str = czytnik.nextLine();
                int licznik = 0;
                for (int i=0; i< str.length(); i++){
                    licznik++;
                }
                System.out.println("String: \"" + str + "\" składa się z " + licznik + " znaku/ów.");
                break;
            }
            case 104: {
                System.out.print("Podaj dowolny napis: ");
                String str = czytnik.nextLine();
                char[] charr = new char[str.length()];
                int licznik = 0;
                for (int i=0; i< str.length(); i++){
                    charr[i] = str.charAt(i);
                }
                for (char c : charr){
                    if (c == ' ') {
                        continue;
                    }
                    licznik++;
                }
                System.out.println("String: \"" + str + "\" składa się z " + licznik + " znaku/ów bez spacji.");
                break;
            }
            case 1042: {
                System.out.print("Podaj dowolny napis: ");
                String str = czytnik.nextLine();
                char znak;
                int licznik = 0;
                for (int i=0; i< str.length(); i++){
                    znak = str.charAt(i);
                    if (znak != ' ') {
                        licznik++;
                    }
                }
                System.out.println("String: \"" + str + "\" składa się z " + licznik + " znaku/ów bez spacji.");
                System.out.println("Tekst małymi literami to: " + str.toLowerCase());
                System.out.println("Tekst dużymi literami to: " + str.toUpperCase());
                break;
            }
            case 5: {
                int suma = 0;
                int liczba = 1;
                do {
                    if ((liczba % 2) != 0) {
                        suma+=liczba;
                    }
                    liczba++;
                } while (liczba <= 100);
                System.out.println("Suma liczb nieparzystych od 1 do 100 wynosi: " + suma);
                break;
            }
            case 6: {
                System.out.print("Pętla FOR A-Z: ");
                for (int i = (int)'A'; i <= (int)'Z'; i++){
                    System.out.print( (char)i );
                }
                System.out.println();
                System.out.print("Pętla FOR Z-A: ");
                for (int i = (int)'Z'; i >= (int)'A'; i--) {
                    System.out.print((char) i);
                }
                System.out.println();

                //pętle while
                int i = (int)'A';
                System.out.print("Pętla while A-Z: ");
                while ( i <= (char)'Z') {
                    System.out.print( (char)i );
                    i++;
                }
                System.out.println();
                i = (int)'Z'; // po ostatnim while mamy 'Z'+1
                System.out.print("Pętla while Z-A: ");
                while ( i >= (int)'A') {
                    System.out.print( (char)i );
                    i--;
                }

                // pętle do..while
                System.out.println();
                i = (int)'A';
                System.out.print("Pętla do..while A-Z: ");
                do {
                   System.out.print( (char)i );
                   i++;
                } while (i <= (int)'Z');

                System.out.println();
                i = (int)'Z';
                System.out.print("Pętla do..while Z-A: ");
                do {
                    System.out.print( (char)i );
                    i--;
                } while (i >= (int)'A');
                break;

            }
            case 7: {
                for (int i = 100; i <= 300; i++){
                    System.out.print(i);
                    String pariti = ( (i%2)==0 ) ? " parzysta" : " nieparzysta";
                    System.out.println(pariti);
                }
                break;
            }
        }
    }
}
