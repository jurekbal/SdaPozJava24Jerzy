package zajecia12.zadania;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Duplicates {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("pierwszy", "drugi", "pierwszy", "czwarty", "piąty");
        System.out.println(strings);

        Set<String> unique = new HashSet<>();
        unique.addAll(strings); // nie dodaje duplikatów
        System.out.println(unique);

        for (String s : unique) {
            System.out.println(s + " " +s.hashCode());
        }
    }
}
