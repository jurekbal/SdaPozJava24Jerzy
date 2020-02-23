package zajecia7.zadaniaDomowe;

// Zadania do domu_weekend_1.pdf - zad 5
// wersja 2: obiektowo
// gra wisielec obiektowo - metoda main i główna pętla
public class WisielecMain {

    public static void main(String[] args) {
        Wisielec gra = new Wisielec();
        do {
            gra.start();
            do {
                gra.status();
                if (gra.zgaduj()) {
                    gra.sprawdzTrafienie();
                    //gra.wyswietlRezultat();
                }
                gra.sprawdzWygrana();
            }while (!gra.isWygrana() && (gra.getLiczbaZyc() > 0));
        } while (!gra.wyjscie());
        System.out.println("Do widzenia.");
    }
}
