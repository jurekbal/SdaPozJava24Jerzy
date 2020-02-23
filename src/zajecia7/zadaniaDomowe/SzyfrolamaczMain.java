package zajecia7.zadaniaDomowe;

// Zadania do domu_weekend_1.pdf - zad 6
public class SzyfrolamaczMain {
    public static void main(String[] args) {

        Szyfrolamacz gra = new Szyfrolamacz();

        do {
            gra.start();

            do {
                gra.typowanie();
                gra.sprawdzenie();
            } while (!gra.koniecGry());

        } while (!gra.wyjscie());
        System.out.println("Koniec gry - do widzenia.");
    }
}
