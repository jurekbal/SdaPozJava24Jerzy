package zajecia6.listaPracownikow;

import java.util.Scanner;

public class Menu {

    public void wyswietlMenuGlowne(){
        System.out.println("### MENU GŁÓWNE ###");
        System.out.println("Wybierz opcję:");
        System.out.println("1: Wyświetl wszystkich pracowników");
        System.out.println("2: Dodaj pracownika");
        System.out.println("3: Eksport do pliku tekstowego");
        System.out.println("4: Usuń pracownika z listy");
        System.out.println("5: Edycja danych pracownika");
        System.out.println("6: Dodatkowe funckje");
        System.out.println("7: Dodatkowe funkcje eksportu");
        System.out.println("8: Informacja o programie");
        System.out.println("99: Generuj pracowników");
        System.out.println("e, q: Zakończ");
        System.out.print("Wybór:");
    }

    public void wyswietlPodmenu6(){
        System.out.println("** DODATKOWE FUNKCJE **\nWybierz funkcję:");
        System.out.println("1: Liczba pracowników z pensją nie mniejszą niż...");
        System.out.println("2: Średnia płaca w dziale");
        System.out.println("3: Największe pensje wśród kobiet / mężczyzn");
        System.out.println("4: Wyświetlanie wszystkich działow i dodatkowych informacji");
        System.out.println("5: Stosunek średniej płacy mężczyzn do średniej płacy kobiet");
        System.out.println("6: Zwieksz pensje wszystkim o 10%, plus premie za dzieci i stan cywilny");
        System.out.println("7: Zwiększ pensje wszystkim o podaną kwotę");
        System.out.println("8: Sortuj bazę według nazwiska");
        System.out.println("9: Sortuj bazę według pensji");
        System.out.println("e, q: powrót");
        System.out.print("Wybór:");
    }

    public void wyswietlPodmenu7() {
        System.out.println("** DODATKOWE FUNKCJE PLIKÓW TEKSTOWYCH **\nWybierz funkcję:");
        System.out.println("1: Wyświetl dane pracownika o najdłuższym nazwisku (z pliku)");
        System.out.println("2: Obliczenie średniego wieku osób posiadających dzieci");
        System.out.println("3: Zakodowanie nazwiska w pliku osób o pensji niższej niż średnia");
        System.out.println("4: Utworzenie pliku 'pracownicy.html'");
        System.out.println("e, q: powrót");
        System.out.print("Wybór:");
    }

    public void wyswietlInformacjeOProgramie() {
        System.out.println("***** INFORMACJE O PROGRAMIE *****");
        System.out.println("Program FIRMA - Lista pracowników");
        System.out.println("Kurs JAVApoz24");
        System.out.println("Autor: Jerzy Balwiński");
        System.out.println("Copyleft 2020, All rights reversed.");

    }

    // z zajęć
    public String pobierzAkcjeOdUzytkownika() {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        return line.toLowerCase();
    }
}
