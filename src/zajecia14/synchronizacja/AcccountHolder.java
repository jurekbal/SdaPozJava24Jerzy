package zajecia14.synchronizacja;

public class AcccountHolder {

    private String name;
    private Account account;

    public AcccountHolder(String name, Account account) {
        this.name = name;
        this.account = account;
    }

    public int withdraw(int value){
        return account.withdraw(value);
    }

    public String getName() {
        return name;
    }
}
