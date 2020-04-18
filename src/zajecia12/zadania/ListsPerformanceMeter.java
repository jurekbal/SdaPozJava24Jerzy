package zajecia12.zadania;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListsPerformanceMeter {
    final static int FINAL_LIST_SIZE = 500_000_0;

    public static void main(String[] args) {


        List<Integer> arraylist = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        System.out.println("Liczba elementów: " + FINAL_LIST_SIZE);

        long arrayListGenerateNanos = generate(arraylist);
        long linkedListGenerateNanos = generate(linkedList);
        System.out.println("Czas generowania ArrayList : " + arrayListGenerateNanos + " ns");
        System.out.println("Czas generowania LinkedList: " + linkedListGenerateNanos + " ns");

        long arrayListFindLastNanos = findLast(arraylist);
        long linkedListFindLastNanos = findLast(linkedList);
        System.out.println("Czas wyszukania ostatniego elementu ArrayList : " + arrayListFindLastNanos + " ns");
        System.out.println("Czas wyszukania ostatniego elementu LinkedList: " + linkedListFindLastNanos + " ns");

        long arrayListAddAtEndNanos = addAtEnd(arraylist);
        long linkedListAddAtEndNanos = addAtEnd(linkedList);
        System.out.println("Czas dodania elementu na koniec ArrayList : " + arrayListAddAtEndNanos + " ns");
        System.out.println("Czas dodania elementu na koniec LinkedList: " + linkedListAddAtEndNanos + " ns");

        long arrayListDelAtBeginNanos = removeAtBegin(arraylist);
        long linkedListDelAtBeginNanos = removeAtBegin(linkedList);
        System.out.println("Czas usunięcia elementu na początku ArrayList : " + arrayListDelAtBeginNanos + " ns");
        System.out.println("Czas usunięcia elementu na początku LinkedList: " + linkedListDelAtBeginNanos + " ns");
    }

    private static long removeAtBegin(List<Integer> list) {
        long start;
        long stop;

        start = System.nanoTime();
        list.remove(0);
        stop = System.nanoTime();
        return stop - start;
    }

    private static long addAtEnd(List<Integer> list) {
        long start;
        long stop;

        start = System.nanoTime();
        list.add(5);
        stop = System.nanoTime();
        return stop - start;
    }

    private static long findLast(List<Integer> list) {
        long start;
        long stop;

        start = System.nanoTime();
        int last = list.size() - 1;
        int value = list.get(last);
        stop = System.nanoTime();
        return stop - start;
    }

    private static long generate(List<Integer> list) {
        //Instant start = Instant.now();
        long start;
        long stop;

        start = System.nanoTime();
        for (int i = 0; i < FINAL_LIST_SIZE; i++) {
            list.add(5);
        }
//        Instant stop = Instant.now();
        stop = System.nanoTime();
//        return Duration.between(start, stop).toMillis();
        return stop - start;
    }
}
