package zajecia6.listaPracownikow;

// program2012.pdf

public class Pracownik {

    private String imie;
    private String nazwisko;
    private char plec; // K, M
    private int nrDzialu;
    private float placa;
    private int wiek;
    private int liczbaDzieci;
    private boolean stanCywilny; // true = mężatka/żonaty;

    public void wyswietlWszystko() {
        System.out.println("Imie: " + this.imie);
        System.out.println("Nazwisko: " + this.nazwisko);
        System.out.println("Płeć: " + this.plec);
        System.out.println("Nr działu: " + this.nrDzialu);
        System.out.println("Płaca: " + this.placa + " zł");
        System.out.println("Wiek: " + this.wiek);
        System.out.println("Liczba dzieci: " + this.liczbaDzieci);
        System.out.println("Stan cywilny: " + (stanCywilny ? "mężatka/żonaty" : "stanu wolnego"));
    }

    public void wyswietlOkrojone() {
        System.out.println("Imie: " + this.imie);
        System.out.println("Nazwisko: " + this.nazwisko);
        System.out.println("Płaca: " + this.placa + " zł");
    }

    public void wyswietlSpecjalne() {
        System.out.println("Imie: " + this.imie.toUpperCase());
        System.out.println("Nazwisko: " + this.nazwisko.toUpperCase());
    }

    public boolean czyPensjaPowyzej(float kwotaDoPorownania) {
        return this.placa > kwotaDoPorownania;
    }

    // zwraca kwotę podwyżki
    public float obliczPodwyzke(float procentBazowyPodwyzki) {
        return (float) (this.placa * (procentBazowyPodwyzki / 100 + this.liczbaDzieci * 0.02 + (stanCywilny ? 0.03 : 0.0)));
    }

    public Pracownik(String imie, String nazwisko, char plec, int nrDzialu, float placa, int wiek, int liczbaDzieci, boolean stanCywilny) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.plec = plec;
        this.nrDzialu = nrDzialu;
        this.placa = placa;
        this.wiek = wiek;
        this.liczbaDzieci = liczbaDzieci;
        this.stanCywilny = stanCywilny;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getImie() {return imie;}

    public char getPlec() {
        return plec;
    }

    public void setPlec(char plec) {
        this.plec = plec;
    }

    public int getNrDzialu() {
        return nrDzialu;
    }

    public void setNrDzialu(int nrDzialu) {
        this.nrDzialu = nrDzialu;
    }

    public float getPlaca() {
        return placa;
    }

    public void setPlaca(float placa) {
        this.placa = placa;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public int getLiczbaDzieci() {
        return liczbaDzieci;
    }

    public void setLiczbaDzieci(int liczbaDzieci) {
        this.liczbaDzieci = liczbaDzieci;
    }

    public boolean isStanCywilny() {
        return stanCywilny;
    }

    public void setStanCywilny(boolean stanCywilny) {
        this.stanCywilny = stanCywilny;
    }
}
