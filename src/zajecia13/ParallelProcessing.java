package zajecia13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ParallelProcessing {
    public static void main(String[] args) {
        List<Printer> printers = new LinkedList<>();
        printers.add(new Printer("Hello from thread - pierwszy", 1000));
        printers.add(new Printer("Hello from thread - drugi", 1500));
        printers.add(new Printer("Hello from thread - trzeci", 2000));
        printers.add(new Printer("Hello from thread - czwarty", 2200));

        List<Thread> threads = new ArrayList<>();
        for (Printer printer : printers) {
            Thread thread = new Thread(printer); // Thread przyjmuje klasy implemantujące Runnable
            thread.start(); // nie run() !!!
            threads.add(thread);
        }

        System.out.println("Hello from main");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
        //threads.get(0).interrupt(); // kończymy tylko sleepa! - dalej wątek dalej jedzie w pętli while
        printers.get(0).deactivate();
    }
}
