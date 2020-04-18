package zajecia12.zadania.liga;

public class Wyniki {
    private int punkty;
    private int wygrane;
    private int remisy;
    private int porazki;
    private int bramkiZdobyte;
    private int bramkiStracone;

    private void obliczPunkty() {
        punkty = wygrane * 3 + remisy;
    }

    public int getPunkty() {
        return punkty;
    }

    public void setPunkty(int punkty) {
        this.punkty = punkty;
    }

    public int getWygrane() {
        return wygrane;
    }

    public void setWygrane(int wygrane) {
        this.wygrane = wygrane;
        obliczPunkty();
    }

    public int getRemisy() {
        return remisy;
    }

    public void setRemisy(int remisy) {
        this.remisy = remisy;
        obliczPunkty();
    }

    public int getPorazki() {
        return porazki;
    }

    public void setPorazki(int porazki) {
        this.porazki = porazki;
    }

    public int getBramkiZdobyte() {
        return bramkiZdobyte;
    }

    public void setBramkiZdobyte(int bramkiZdobyte) {
        this.bramkiZdobyte = bramkiZdobyte;
    }

    public int getBramkiStracone() {
        return bramkiStracone;
    }

    public void setBramkiStracone(int bramkiStracone) {
        this.bramkiStracone = bramkiStracone;
    }
}
