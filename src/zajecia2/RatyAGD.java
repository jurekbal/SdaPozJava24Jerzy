package zajecia2;

import java.util.Scanner;

public class RatyAGD {
    public static void main(String[] args){
        Scanner czytnik = new Scanner(System.in);

        System.out.print("Podaj cenę (100 - 10 000 zł): ");
        double cena = czytnik.nextDouble();
        if (cena < 100 || cena > 10_000) {
            System.out.println("Niewłaściwa cena. Masz ostatnią szansę.");
            System.out.print("Podaj cenę (100 - 10 000 zł): ");
            cena = czytnik.nextDouble();
            if (cena < 100 || cena > 10_000){
                System.out.println("Niewłaściwa cena. Przyjęto domyślną cenę 10 000 zł.");
                cena = 10_000;
            }
        }
        System.out.print("Podaj ilość rat (od 6 do 48 rat): ");
        int iloscRat = czytnik.nextInt();
        if (iloscRat < 6 || iloscRat > 48) {
            System.out.println("Niewłaściwa ilość rat. Masz ostatnią szansę.");
            System.out.print("Podaj ilość rat (od 6 do 48 rat): ");
            iloscRat = czytnik.nextInt();
            if (iloscRat < 6 || iloscRat > 48){
                System.out.println("Niewłaściwa ilość rat. Przyjęto domyślną ilośc rat: 6");
                iloscRat = 6;
            }
        }

        double oprocentowanie;
        if (iloscRat < 13) oprocentowanie = 0.025;
        else if (iloscRat < 25) oprocentowanie = 0.05;
        else oprocentowanie = 0.1;

        System.out.println("Cena towaru: " + cena + " zł; " + "Ilość rat: " + iloscRat + "; Oprocentowanie od ceny: " + (oprocentowanie*100) + "%");
        System.out.println("Wielkość raty: " + ((cena + (cena*oprocentowanie))/iloscRat) + " zł");
        System.out.println("Całkowita kwota odsetek: " + (cena*oprocentowanie) + " zł");


    }
}
