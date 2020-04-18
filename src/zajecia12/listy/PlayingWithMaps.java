package zajecia12.listy;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PlayingWithMaps {

    public static void main(String[] args) {
        Map<String, String> dictionary = new HashMap<>();

        dictionary.put("klucz", "wartość");
        dictionary.put("hasło", "definicja hasła");
        dictionary.put("abstract", "dla klasy, metody - oznacza abstrakcję...");

        System.out.println(dictionary.get("abstract"));
        System.out.println("abstract : " + dictionary.get("abstract"));

        String a = "abc";
        String b = "def";
        String c = "def";
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(c.hashCode());
        System.out.println(dictionary.hashCode());

        // zbiory Set
        Set<String> klucze = dictionary.keySet();
        Collection<String> definicje = dictionary.values();
    }
}
