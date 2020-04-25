package zajecia14.synchronizacja;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Account shared = new Account(1000);

        AcccountHolder wife = new AcccountHolder("Wife", shared);
        AcccountHolder husband = new AcccountHolder("Husband", shared);

        List<AcccountHolder> holders = new ArrayList<>();
        holders.add(wife);
        holders.add(husband);

        for (AcccountHolder holder : holders) {
            // tu nie implementujemy runnable w AccountHolder, ale wykożystujemy klasę anonimową
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    int withdraw = holder.withdraw(1000);
                    System.out.println(holder.getName() + " " + withdraw+ " " + Thread.currentThread().getId());
                }
            });
            t.start();

        }
    }
}
