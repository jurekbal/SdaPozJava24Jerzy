package zajecia6.listaPracownikow;

// program2012.pdf

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
        ListaPracownikow lista = new ListaPracownikow();

        String wyborMenu = "";
        while(!wyborMenu.equals("e") && !wyborMenu.equals("q")){
            menu.wyswietlMenuGlowne();
            wyborMenu = menu.pobierzAkcjeOdUzytkownika();
            switch (wyborMenu) {
                case "1": {
                    lista.wypiszWszystkich();
                    break;
                }
                case "2": {
                    lista.dodajPracownika();
                    break;
                }
                case "3": case "7":{
                    System.out.println("Przepraszamy. Funkcja nie jest dostępna w tej wersji programu.");
                    break;
                }
                case "4": {
                    lista.usunPracownika();
                    break;
                }
                case "5": {
                    lista.edycjaDanych();
                    break;
                }
                case "6": {
                    menu.wyswietlPodmenu6();
                    wyborMenu = menu.pobierzAkcjeOdUzytkownika();
                    lista.dodatkoweFunkcje(wyborMenu);
                    wyborMenu = "";
                    break;
                }
                case "q": case "e": {
                    System.out.println("Koniec programu. Do widzenia.");
                    break;
                }
                default :{
                    System.out.println("BŁĄD. Wybrano nieprawidłową opcję.");
                    break;
                }
            }
        }
    }

}
