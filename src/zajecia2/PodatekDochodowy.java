package zajecia2;

import java.util.Scanner;

public class PodatekDochodowy {
    public static void main(String[] args){

        Scanner czytnik = new Scanner(System.in);
        System.out.print("Podaj dochód: ");
        final double PROG_PODATKOWY = 85_528; // final = stała; konwencja nazewnicza - duże litery
        double dochod = czytnik.nextDouble();
        double podatek;

        if (dochod < PROG_PODATKOWY ) {
            podatek = ((0.18 * dochod) - 556.02);
            if (podatek < 0) {
                podatek = 0;
            }
            System.out.println("Podatek PIT wynosi: " + podatek);
            System.out.println("Nie przekroczyłeś pierwszego progu podatkowego.");
        } else {
            System.out.println("Podatek PIT wynosi: " + (14_839.02 + (0.32 * (dochod - PROG_PODATKOWY))));
            System.out.println("Przekroczyłeś próg podatkowy.");
        }

    }
}
