package zajecia14.synchronizacja;

public class Account {

    private int balance;

    public Account(int value) {
        this.balance = value;
    }

    synchronized public int withdraw(int toWithdraw){
        System.out.println("Jestem w środku "+ Thread.currentThread().getId());

        if (balance >= toWithdraw) {
            // bez synchronized oba wątki wypłącą kasę, bo oba przejdą przez if-a
            try {
                Thread.sleep(3* 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance-= toWithdraw;
            return toWithdraw;
        } else {
            return 0;
        }
    }
}
