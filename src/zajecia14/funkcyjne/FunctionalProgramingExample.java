package zajecia14.funkcyjne;

import java.util.LinkedList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FunctionalProgramingExample {

    public static void main(String[] args) {
        // boilerplate - np. nawiasy... zbędny kod który nie stanowi treści

        // lambda
        // () -> ()
        // definicja -> blok kodu do wykonania
        // zob klasę Bank w tym pakiecie (oraz Main w generykach (kod prowadzącego)

        // strumienie:
        //nonFunctional();
        //functional();
        //functional2();
        //czaryNaStrumieniu();

        // zad
        //sredniaFunkcyjnie();

        //zad
        // zwroc true jeśli w podanym zakresie (parametry) znajduje się kwadrat liczby naturalnej 1..10
        System.out.println(isBetween(24, 26));
        System.out.println(isBetween(26, 35));
    }

    private static boolean isBetween(int bottom, int up) {
        return IntStream.rangeClosed(1,10).
                map(n -> n*n).
                anyMatch(n -> n >= bottom && n <= up);

    }

    private static void sredniaFunkcyjnie() {
        // strumieniem
        OptionalDouble srednia = IntStream.rangeClosed(101,150).average();

        if (srednia.isPresent()) {
            System.out.println(srednia.getAsDouble());
        }
    }

    private static void czaryNaStrumieniu() {
        OptionalInt sum = IntStream.rangeClosed(0,100).
                filter(n -> n < 6).
                map(n -> n * 3).
                reduce((n1, n2) -> n1 + n2);

        if (sum.isPresent()) {
            System.out.println(sum.getAsInt());
        } else {
            System.out.println("No value");
        }

        // bez użycia OptionalInt
        int sumInt = IntStream.rangeClosed(0,100).
                filter(n -> n < 6).
                map(n -> n * 3).
                reduce((n1, n2) -> n1 + n2).
                orElse(0);

        System.out.println(sumInt);

    }

    private static void functional2() {
        List<Integer> ints = IntStream.rangeClosed(0,100).
                filter(n -> n % 2 == 0).
                boxed().
                collect(Collectors.toList());

        System.out.println(ints);
    }

    private static void functional() {
        List<Integer> ints = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            ints.add(i);
        }

        List<Integer> ints2 = ints.stream().
                filter(n -> n %2  == 0).
                collect(Collectors.toList());
        //co tu się odj..ało:
        // zamiana listy na strumień , filtracja, zebranie do listy i przypisanie do nowej listy

        System.out.println(ints2);
    }

    private static void nonFunctional() {
        List<Integer> ints = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            ints.add(i);
        }

        for (int i = 0; i < ints.size(); i++) {
            if (i % 2 == 0) {
                ints.remove(i);
                i--;
            }
        }
        System.out.println(ints);
    }
}
