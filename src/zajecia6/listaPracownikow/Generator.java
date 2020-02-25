package zajecia6.listaPracownikow;

import java.util.Random;

public class Generator {
   
    private String[] imionaMeskie = {"Adam", "Bartosz", "Czesław", "Dariusz", "Edward", "Franciszek", "Grzegorz",
            "Henryk", "Igor", "Jerzy", "Karol", "Leszek", "Mariusz", "Orest", "Piotr", "Roman", "Stefan", "Tomasz",
            "Waldemar", "Zenon"}; // 20 szt
    private String[] imionaZenskie = {"Anna", "Beata", "Celina", "Daria", "Edyta", "Grażyna", "Hanna", "Iwona",
            "Joanna", "Karolina", "Lena", "Magdalena", "Nadia", "Olga", "Patrycja", "Roma", "Sandra", "Tamara",
            "Urszula", "Wanda"}; // 20 szt
    private String[] nazwiskaMeskie = {"Nowak", "Kowalski", "Wójcik", "Kamiński", "Zieliński", "Woźniak", "Kozłowksi",
            "Wojciechowski", "Mazur", "Kaczmarek", "Grabowski", "Michalski", "Król", "Jabłoński", "Nowakowski",
            "Majewski", "Olszewski", "Malinowski", "Górski", "Nowicki"};
    private String[] nazwiskaZenskie = {"Nowak", "Wiśniewska", "Kowalczyk", "Lewandowska", "Szymańska", "Dąbrowska",
            "Jankowska", "Kwiatkowska", "Krawczyk", "Piotrowska", "Pawłowska", "Zając", "Jabłońska", "Wieczorek",
            "Wróbel", "Stępień", "Jaworska", "Adamczyk", "Pawlak", "Dudek"};

    Random random = new Random();

    public Pracownik generuj() {
        char plec = generujPlec();
        String imie = "";
        String nazwisko = "";
        if (plec == 'M') {
            imie = generujImieMeskie();
            nazwisko = generujNazwiskoMeskie();
        } else {
            imie = generujImieZenskie();
            nazwisko = generujNazwiskoZenskie();
        }
        int nrDzialu = generujNrDzialu();
        float placa = generujPlace();
        int wiek = generujWiek();
        int liczbaDzieci = generujLiczbaDzieci();
        boolean stanCywilny = generujStanCywilny();
        return new Pracownik(imie, nazwisko, plec, nrDzialu, placa, wiek, liczbaDzieci, stanCywilny);
    }

    private String generujImieMeskie() {
        return imionaMeskie[random.nextInt(imionaMeskie.length)];
    }

    private String generujImieZenskie() {
        return imionaZenskie[random.nextInt(imionaZenskie.length)];
    }

    private String generujNazwiskoMeskie() {
        return nazwiskaMeskie[random.nextInt(nazwiskaMeskie.length)];
    }

    private String generujNazwiskoZenskie() {
        return nazwiskaZenskie[random.nextInt(nazwiskaZenskie.length)];
    }

    private char generujPlec() {
        return random.nextBoolean() ? 'M' : 'K';
    }

    private int generujNrDzialu() {
        return random.nextInt(10) + 1;
    }

    private float generujPlace() {
        return ((random.nextFloat() * 12000) + 1600);
    }

    private int generujWiek() {
        return random.nextInt(50) + 18;
    }

    private int generujLiczbaDzieci() {
        return random.nextInt(5);
    }

    private boolean generujStanCywilny() {
        return random.nextBoolean();
    }

}
