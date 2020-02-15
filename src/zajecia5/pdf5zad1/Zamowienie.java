package zajecia5.pdf5zad1;

public class Zamowienie {
    private final static int DOMYSLNY_ROAMIAR_ZAMOWIENIA = 10;
    private Pozycja[] pozycje;
    private int ileDodanych;
    private int maksRozmiar;

    // moj konstruktor
//    public Zamowienie(){
//        maksRozmiar = DOMYSLNY_ROAMIAR_ZAMOWIENIA;
//        this.pozycje = new Pozycja[maksRozmiar];
//    }

    //konstruktor bezparametrowy z zajęć - wywołanie konstruktora z konstruktora
    public Zamowienie() {
        this(DOMYSLNY_ROAMIAR_ZAMOWIENIA); //sposób na wywołanie własnego konstruktora;
    }

    public Zamowienie(int maksRozmiar) {
        this.maksRozmiar = maksRozmiar;
        this.pozycje = new Pozycja[maksRozmiar];
    }

    public void dodajPozycje(Pozycja p) {
        if (this.ileDodanych >= this.maksRozmiar) {
            System.out.println("Nie można dodać pozycji - osiagnięto maksymalną liczbę.");
        } else {
            this.pozycje[ileDodanych++] = p;
        }
    }

    public double obliczWartosc() {
        double suma = 0;
        for (int i = 0; i < this.ileDodanych; i++) {
            suma += pozycje[i].obliczWartosc();
        }
//         // alternatywnie
//         for (Pozycja p : pozycje) {
//         if (p != null) {
//              suma += p.obliczWartosc();
//         }

        return suma;
    }

    public String toString() {
        String zamText = "";
        zamText += "\n\nZamówienie:\n";
        for (int i = 0; i < ileDodanych; i++) {
            zamText += pozycje[i].toString() + '\n';
        }
        zamText += '\n';
        zamText += "Razem: " + this.obliczWartosc() + " zł";
        return zamText;
    }
}
