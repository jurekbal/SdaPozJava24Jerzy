package zajecia5.pdf5zad1;

public class ZamProgram {

    public static void main(String[] args) {
        Pozycja p1 = new Pozycja("Chleb", 1, 3.5);
        System.out.println(p1);
        Pozycja p2 = new Pozycja("Cukier", 3, 4);
        System.out.println(p2);
        Pozycja p3 = new Pozycja("Masło", 2, 8.99);
        System.out.println(p3);

        Zamowienie z = new Zamowienie(20);
        z.dodajPozycje(p1);
        z.dodajPozycje(p2);
        z.dodajPozycje(p3);
        System.out.println(z);
    }
}
