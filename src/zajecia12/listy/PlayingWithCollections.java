package zajecia12.listy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlayingWithCollections {
    public static void main(String[] args) {
        Random random = new Random();

        List<Integer> numbers = new ArrayList<>(20);

        for (int i = 0; i < 10; i++) {
            int number = random.nextInt(11);
            numbers.add(number);
        }

        for (int number: numbers) {
            System.out.print(number+" ");
        }

        for (int i = 0; i < numbers.size(); i++) {
            int number = numbers.get(i);
            if (number % 2 == 0) {
                numbers.remove(i--); // wracamy do wlasciwego indeksu po remove
            }
        }

        System.out.println();
        for (int number: numbers) {
            System.out.print(number+" ");
        }




    }
}
