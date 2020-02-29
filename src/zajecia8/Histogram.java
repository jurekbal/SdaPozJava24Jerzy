package zajecia8;

import java.util.Arrays;
import java.util.Random;

//Stworzyć tablicę z miejscem na 100 elementów.
//Wygenerować losowo do niej elementy z zakresu 10-30;
//Zrobić histogram tych wartości czyli policzyć na tablicach ile występuje elementów o danej wartości.
//Histogram może być wypisany poziomo. Wyspisać to podobnie jak w zadaniu z gwiazdkami.
public class Histogram {
    public static void main(String[] args) {
        int[] tab = new int[100];
        Random random = new Random();
        int[] histogram = new int[21];

        for (int i=0; i < tab.length; i++){
            tab[i] = random.nextInt(21) + 10;
            histogram[tab[i] - 10]++;
        }

        System.out.println(Arrays.toString(tab));
        System.out.println(Arrays.toString(histogram));

        for (int i = 0; i < histogram.length; i++) {
            System.out.print(i+10 + ": " + "*".repeat(histogram[i]));
            System.out.println("(" + histogram[i] + ")");
        }
    }
}
