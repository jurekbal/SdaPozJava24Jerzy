package zajecia5; // zawsze pierwsa instrukcja w klasie

// Programowanie obiektowe

public class Osoba {
    // klejność w klasie (konwencja):
    // pola
    // ..
    // metody

    // pola:
    public String imie;
    public String nazwisko;
    public int wiek;
    public double wzrost;
    public double waga;
    // pola domyślnie są prywatne (tutaj zrobilismy publiczne)

    // konstruktor:
    // 1. jest specjalną metodą (funkcją)
    // 2. nazywa się tak samo jak klasa
    // 3. nie ma typu zwracanego - nawet void

    // konstruktor bezparametrowy; także domyślny - pusty {}
    public Osoba(){
        System.out.println("Tworzę obiekt typu osoba...");
    }
    // domyślny konstruktor bezparam. jest tworzony tylko jeżeli nie zdefiniowaliśmy
    // konstruktora parametrowego

    // przeciążanie konstruktorów - możemy mieć więcej niż jeden konstruktor w klasie
    public Osoba(String imie, String nazwisko, int wiek){
        this.imie = imie; // this uzywamy aby uniknąc kolizji nazw pół i parametrów
        this.nazwisko = nazwisko; // this uzywamy w ciele klasy aby odnieść się do składowych klasy
        this.wiek = wiek;
        //wiek = w; // to działa jeżeli nazawa parametru jest inna niż nazwa pola, ale zazwyczaj
                    // używa się tych samych nazw bo w wywołaniu mamy wtedy odpowiadające nazwy pól.

    }

    public String przedstawSie(){
        return "Na imię mam " + this.imie + ", nazywam się " + this.nazwisko + " i mam " + wiek + " lat.";
        // można użyć this, ale nie trzeba
    }

}
