package zajecia6.listaPracownikow;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Menu {

    public void wyswietlMenuGlowne(){
        System.out.println("### Menu głóne ### Wybierz opcję:");
        System.out.println("1: Wyświetl wszystkich pracowników");
        System.out.println("2: Dodaj pracownika");
        System.out.println("3: Eksport do pliku");
        System.out.println("4: Usuń pracownika z listy");
        System.out.println("5: Edycja danych pracownika");
        System.out.println("6: Dodatkowe funckje");
        System.out.println("7: Dodatkowe funkcje eksportu");
        System.out.println("99: Generuj pracowników");
        System.out.println("e, q: Zakończ");
        System.out.print("Opcja:");
    }

    public void wyswietlPodmenu6(){
        System.out.println("** Dodatkowe fukcje. Wybierz funkcję:");
        System.out.println("1: Liczba pracowników z pensją nie mniejszą niż...");
        System.out.println("2: Średnia płaca w dziale");
        System.out.println("3: Największe pensje wśród kobiet / mężczyzn");
        //TODO Uzupełnić listę funkcji dodatkowych
        System.out.println("e, q: powrót");
        System.out.print("Wybór:");
    }

    // z zajęć
    public String pobierzAkcjeOdUzytkownika() {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        return line.toLowerCase();
    }
}
