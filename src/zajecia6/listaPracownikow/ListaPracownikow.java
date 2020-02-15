package zajecia6.listaPracownikow;

import java.util.Scanner;

public class ListaPracownikow {
    public Pracownik[] lista = new Pracownik[100];
    private int liczbaPracownikow;
    Scanner sc = new Scanner(System.in);

    // funkcja 1
    public void wypiszWszystkich(){
        for (int i = 0; i < liczbaPracownikow; i++) {
            System.out.println("Pracownik " + (i) + ":");
            lista[i].wyswietlOkrojone();
        }
        if (liczbaPracownikow == 0) {
            System.out.println("Lista jest pusta.");
        }
    }

    public void dodajPracownika() {
        if (liczbaPracownikow < 100){

            System.out.println("dodajesz pracownika nr " + liczbaPracownikow);
            System.out.print("Podaj Imię:");
            String imie = sc.nextLine();
            //TODO formatowanie imienia
            System.out.print("Podaj Nazwisko:");
            String nazwisko = sc.nextLine();
            //TODO formatowanie nazwiska
            //TODO Odcytać resztę danych
            liczbaPracownikow++;
        } else{
            System.out.println("Błąd. Lista jest pełna.");
        }

    }
}
