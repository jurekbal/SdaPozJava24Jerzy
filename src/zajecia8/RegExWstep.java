package zajecia8;

public class RegExWstep {

    public static void main(String[] args) {
        String zdanie = "Bardzo lubię uczyć się Javy, ale czasami wolę: JavaScript. Pythona, Scale.";

        //Zadanie 1: podzielić poniższe zdanie na tablice z wyrazami.
        String regex = "[\\s.,:]+"; // lub [ .,:]+

        String[] wyrazy = zdanie.split(regex);

        System.out.println("*** tablica ma " + wyrazy.length + " elementów ***");
        for (String s: wyrazy) {
            System.out.println(s);
        }

        // Zadanie 2: zastąpić w zdaniu, każde wystąpienie litery a znakiem @.
        System.out.println("** Zadanie 2 (a na @):");
        regex = "a";
        String noweZdanie = zdanie.replaceAll(regex, "@");
        System.out.println(noweZdanie);

        //Zadanie 3: dla chętnych: Zamienić w słowach kończących się na literę a na @
        System.out.println("** Zadanie 3 (a na @ tylko gdy wyraz kończy się na a):");
        regex = "a[\\s.,:]";
        noweZdanie = zdanie.replaceAll(regex, "@");
        System.out.println(noweZdanie);
    }



}
