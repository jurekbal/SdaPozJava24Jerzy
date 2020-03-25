package zajecia6.listaPracownikow;

// program2012.pdf

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
                case "3":{
                    lista.eksport();
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
                    lista.dodatkoweFunkcje(menu);
                    break;
                }
                case "7":{
                    lista.funkcjePlikowTekstowych(menu);
                    break;
                }

                case "8":{
                    menu.wyswietlInformacjeOProgramie();
                    lista.nacisnijEnter();
                    break;
                }
                case "99" : {
                    lista.generujPracownikow();
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
