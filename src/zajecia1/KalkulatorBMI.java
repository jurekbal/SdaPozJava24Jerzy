package zajecia1;

import java.util.Scanner;

public class KalkulatorBMI {
    // <18,5    -> niedowaga
    // 18,5-25  -> waga prawidłowa
    // 25-30    -> nadwaga
    // >30      -> otyłość

    public static void main(String[] args) {

        double wzrost; // [cm]
        double masa; // [kg]
        double bmi;
        Scanner czytnik = new Scanner(System.in);

        System.out.print("Podaj masę w kg: ");
        masa = czytnik.nextDouble();
        System.out.print("Podaj wzrost w cm: ");
        wzrost = czytnik.nextDouble() / 100;
        bmi = (masa / (wzrost * wzrost));
        System.out.println("Twoje BMI wynosi: " + bmi);

//        Ctrl+Alt+L - formatuje kod

        if (bmi > 18.5 && bmi < 25) {
            System.out.println("WAGA OK - waga w normie");
        } else {
            System.out.println("Zły wynik - waga za duża lub za mała");
        }
    }
}
