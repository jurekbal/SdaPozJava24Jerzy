package zajecia3.arrays;

//http://www.jkozak.pl/przedmioty/java/zadania3.pdf
//Zadanie 4 - Kod binarny ZM

import java.util.Scanner;

public class Zadanie4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj liczbę: ");
        int liczba = sc.nextInt();

        int[] tablica = new int[32];
        int rozkladana;
        if (liczba <0) {
            rozkladana = liczba * -1;
            tablica[0] = 1;
        }
        else {
            rozkladana = liczba;
            tablica[0] = 0;
        }

        int poz;
        for (poz = 31; poz > 0; poz--){
            tablica[poz] = rozkladana % 2;
            rozkladana /= 2;
            if (rozkladana == 0) {
                break; // zachowujemy pozycje najbardziej znaczącego bitu
            }
        }


        System.out.print("Liczba " + liczba + " binarnie: " + tablica[0] + ".");
        for (int i = poz; i<tablica.length; i++) { //drukowanie bez zer przewodnich, od pozycji wskazanej przez poz
            System.out.print(tablica[i]);
        }

    }

}
