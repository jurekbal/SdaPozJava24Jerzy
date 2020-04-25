package zajecia14.refleksje;

import zajecia14.synchronizacja.AcccountHolder;
import zajecia14.synchronizacja.Account;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Account shared = new Account(1000);

        //refleksje (przykład):
        Method[] methods = shared.getClass().getMethods();
        for (Method m : methods ) {
            System.out.println(m.getName());
        }
        Field[] fields = shared.getClass().getFields();
        for (Field f : fields) {
            System.out.println(f.getName()); // tu coś nie działa?
        }

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
