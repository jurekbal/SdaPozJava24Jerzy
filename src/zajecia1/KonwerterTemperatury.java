package zajecia1;

import java.util.Scanner;

public class KonwerterTemperatury {
    public static void main(String[] args){

        double temperatura;

          Scanner czytnik = new Scanner(System.in);
//        można tez tak jeśli nie ma importu:
//        java.util.Scanner czytnik = new java.util.Scanner(System.in);

        System.out.print("Podaj temperaturę w st. Celsjusza: ");
        temperatura = czytnik.nextDouble();
        System.out.println("Ta temperatura w st. Farenheita wynosi: " + ((1.8 * temperatura) + 32.0));

        System.out.print("Podaj temperaturę w st. Farenheita: ");
        temperatura = czytnik.nextDouble();
        System.out.println("Ta temperatura w st. Celsjusza wynosi: " + ((temperatura-32)/1.8));
    }
}
