package zajecia5.pdf5zad1;

public class Pozycja {
    private String nazwaTowaru;
    private int ileSztuk;
    private double cena;

    public Pozycja(String nazwaTowaru, int ileSztuk, double cena){
        this.nazwaTowaru = nazwaTowaru;
        this.ileSztuk = ileSztuk;
        this.cena = cena;
    }

    public double obliczWartosc(){
        return ileSztuk * cena;
    }

    public String toString(){
        // bez zachowania wymaganje ilości znaków
        return nazwaTowaru + '\t' + cena + " zł" + '\t' + ileSztuk + " szt." + '\t' + obliczWartosc() + " zł";
    }
}
