package zajecia13;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WorkersMain {
    public static void main(String[] args) {
        int currentReportDuration = 10000;
        List<Worker> workers = new ArrayList<>();
        workers.add(new Worker("Damian", currentReportDuration));
        workers.add(new Worker("Roman", currentReportDuration));
        workers.add(new Worker("Michał", currentReportDuration));
        workers.add(new Worker("Maciej", currentReportDuration));

        Random random = new Random();
        for (Worker w : workers) {
            try {
                Thread.sleep(random.nextInt(10000));
            } catch (InterruptedException e) {
            }
            Thread thread = new Thread(w);
            thread.start();
        }

        while (anyWorking(workers)) {
            try {
                 Thread.sleep(30000);
             } catch (InterruptedException e) { }

            int randomWorkerIndex = random.nextInt(workers.size());
            workers.get(randomWorkerIndex).deactivate();
            workers.remove(randomWorkerIndex);
            for (Worker w : workers) {
                w.setReportDuration(w.getReportDuration() - 2000);
            }
        }

    }

    private static boolean anyWorking(List<Worker> workers) {
        for (Worker worker: workers) {
            if (worker.isActive()) {
                return true;
            }
        }
        return false;
    }
}
