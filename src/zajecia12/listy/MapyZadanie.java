package zajecia12.listy;

import java.util.HashMap;
import java.util.Map;

// zadanie 3 z prezentacji
public class MapyZadanie {
    public static void main(String[] args) {
        Map<Long, String> names = new HashMap<>();

        names.put(1L, "Adrianna");
        names.put(2L, "Mariusz");
        names.put(3L, "Mateusz");
        names.put(4L, "Antoni");
        names.put(5L, "Bolesław");
        names.put(6L, "Jan");
        names.put(7L, "Tomasz");
        names.put(8L, "Jan");
        names.put(9L,"Monika");
        names.put(10L, "Jan");
        names.put(11L, "Alfred");

        // wyswietl wszystkie imiona zaczynające się na A
        for (String name : names.values()) {
            if (name.charAt(0) == 'A') { // wariant: name.startsWith("A")
                System.out.println(name);
            }
        }
        System.out.println("**********");


        //wyswietl id klucza (klucz) imion "Jan"
        System.out.println("Klucze dla imienia \"Jan\":");
        for (Long key : names.keySet()) {
            if (names.get(key).equals("Jan")) {
                System.out.println(key + " ");
            }
        }

        // wariant z lekcji
        for (Map.Entry<Long, String> entry : names.entrySet()) { //pobieramy parę (rekord) i na nim operujemy
            if ("Jan".equals(entry.getValue())) {
                System.out.println("ID: " + entry.getKey() + " to Jan");
            }
        }
    }
}
