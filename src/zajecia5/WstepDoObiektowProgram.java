package zajecia5;

public class WstepDoObiektowProgram {
    // pierwsze przykłady tworzenia obiektów

    public static void main(String[] args) {

        // Student jest obiektem typu osoba
        Osoba student = new Osoba();
        student.imie = "Jurek";
        student.nazwisko = "Balwiński";
        student.wiek = 37;
        student.wzrost = 1.80;
        student.waga = 80;

        // uczen jest obiektem typu Osoba
        Osoba uczen = new Osoba();
        uczen.imie = "Franc";
        uczen.nazwisko = "Kafka";
        uczen.wiek = 17;
        //uczen.wzrost = 1.75;
        //uczen.waga = 56;
        // celowo pomijamy 2 pola

        //odczyt pola
        String a = student.imie;
        System.out.println("Wartość pola to: " + a);
        //lub prościej (preferowane):
        System.out.println("Nazwisko studenta to: " + student.nazwisko);
        System.out.println(student.waga);

        // wartosci drugiego obiektu (ucznia)
        System.out.println(uczen.imie);
        System.out.println(uczen.nazwisko);
        System.out.println(uczen.wiek);

        //wartościa domyślną dla typów obiektowych (w tym pól typu obiektowego np String)
        // jest "null"
        // dla typów prostych:
        // dla wartości liczbowych jest 0 i 0.0; dla typu boolean: false; char - chyba 0;

        // zmiana wartości
        student.nazwisko = "AAAAAAAAA";
        System.out.println("Nazwisko studenta po zmianie: " + student.nazwisko);

        Osoba persona = new Osoba("Mariusz", "Kowalski", 28);
        System.out.println(persona.imie + ' ' + persona.nazwisko + ' ' + persona.wiek);

        // wywołjemy metodę przedstaw się
        System.out.println(student.przedstawSie());
        System.out.println(uczen.przedstawSie());
        System.out.println(persona.przedstawSie());
    }
}
