package myotherstuff;

import java.util.Scanner;
import java.util.function.DoubleToIntFunction;

public class KwotaSlownie {
    public static void main(String[] args){

        System.out.print("Kwota: ");
        Scanner sc = new Scanner(System.in);
        double kwota = sc.nextDouble();

        // obliczanie groszy
        long calkowite = (int)kwota;
        long grosze = Math.round( (100 * (kwota - calkowite)) );

        /*Algorytm

        odmiana kwantyfikatorów i waluty dla różnych liczb:
        0, 5-9 - tysięcy, milionów, złotych
        1 -  złoty
        x1 - złotych
        2, 3, 4 - złote
        x2,x3 ,x4 -  tysięcy, miliony
        1xxx (jeden) tysiąc
        2xxx, 3xxx, 4xxx N tysiące
        5xxx .. N tysięcy
        11xxx jedenaście tysięcy
        liczebniki:
        1 - jeden
        2, 3, 4 - dwa, trzy, cztery,
        0, 5-9 zero, pięć .. dziewieć
        11-19 - jedenaście .. dziewiętnaście
        2x - dwadzieścia
        3x - trzydzieści
        .. 9x - dziewięćdziesiąt
        1xx - sto xx
        .. 9xx - dziewięćset

         */

        String slownie;
        String waluta;
        int rozklad;

        // obliczanie jedności
        rozklad = (int)(calkowite % 10);

        // TODO waluta dla nastych
        if (rozklad == 0 || (rozklad >= 5 && rozklad <= 9)) {
            waluta = "złotych";
        }
        else if (rozklad >= 2 && rozklad <= 4){
            waluta = "złote";
        }
        else {
            if (calkowite == 1) {
                waluta = "złoty";
            } else {
                waluta = "złotych"; // gdy kwota to zero złotych;
            }
        }
        System.out.println(calkowite+","+grosze+" "+waluta);



    }
}
