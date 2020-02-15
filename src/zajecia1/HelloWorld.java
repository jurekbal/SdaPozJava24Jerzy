package zajecia1;

public class HelloWorld {
    // ta klasa musi nazywac się tak jak nazwa pliku
    // może jednak nazywać się inaczej jeśli nie jest public (i też działa)
    // nazwy klas zaczynamy z dużej litery

    public static void main(String[] args) {

        System.out.print("Jerzy Balwiński "); //print vs println
        //  Komentarz - Ctrl+/  - zakomentuje lub odkomentuje daną linię
        System.out.println("Zajęcia SDA z Javy");
    /*

    Komentaż wielolinijkowy!
    Kolejna linia komentzarza wl.

     */

        byte malaLiczba = 10; //nazwy zmiennych zaczynamy z małej litery
        // byte - 1 bajt - -128 do +127
        // pierwszy bit to bit znaku
        short kolejnaMalaLiczba; //2 bajty -32 768 do 32 767
        kolejnaMalaLiczba = 100;
        int wiek = 30; // 4 bajty -2 147 483 648 do 2 147 483 647

        long bardzoDuzaLiczba = 4_000_000_000_0L; // 8 bajtow -2^64 do 2^64-1  + konwersja z integer na long
//        long bardzoDuzaLiczba = 4_000_000_000_0; // błąd bo domyślny typ w Javie to int
//        // i wartość jest większa niż zakres dla int
        double numberPi = 3.14; // double to typ domyślny dla liczb zmiennoprzecinkowych.
        float liczbaPi = 3.14f; // konwersja z double na float
//        float liczbaPi 3.14; // błąd bo typ domyślny zmiennorzpecinkowy to double)
        //String imie = new String("Jurek"); // string jest obiektem
        String imie = "Jurek"; // wyjątek dla stringa - skrócona inicjalizacja - tylko dla obiektu String

        boolean czyPada = false;

        char znak = 'A'; // reprezentuje jeden znak unicode (wart. od 0 do 65 536)

        System.out.println(malaLiczba);
        System.out.println(numberPi);
        System.out.println(imie);
        System.out.println(czyPada);
        System.out.println(imie);

    }

}
