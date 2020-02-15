package zajecia2;

import java.util.Scanner;

public class KalkulatorBMI {
    // <18,5    -> niedowaga
    // 18,5-25  -> waga prawidłowa
    // 25-30    -> nadwaga
    // >30      -> otyłość

    public static void main(String[] args) {

        Scanner czytnik = new Scanner(System.in);

        // pętla wchile to moja inwencja na tym etapie - ułatwia testowanie
        while (true) {
            System.out.print("Podaj wagę w kg (0 = koniec programu): ");
            double masa = czytnik.nextDouble(); // [kg]
            if (masa == 0) {
                System.out.println("Do widzenia.");
                break;
            }
            System.out.print("Podaj wzrost w cm: ");
            double wzrost = czytnik.nextDouble() / 100; // [cm]

            double bmi;
            bmi = (masa / (wzrost * wzrost));
            System.out.println("Twoje BMI wynosi: " + bmi);


            if (bmi < 18.5) {
                System.out.println("Niedowaga");
            } else if (bmi < 25) {
                System.out.println("WAGA OK - waga w normie");
            } else if (bmi <= 30) {
                System.out.println("Nadwaga");
            } else {
                System.out.println("Otyłość");
            }
        }
    }
}
