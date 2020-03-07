package zajecia10.bank;

public class Account {
    private Client client;
    private String accountNumber;
    protected long ballance; //protected bo chcemy móc zmienić ballance w klasie pochodnej

    public Account(Client client, String accountNumber, long initialBallance) {
        this.client = client;
        this.accountNumber = accountNumber;
        this.ballance = initialBallance;
    }

    public boolean deposit(long amount) {
        if (amount > 0) {
            this.ballance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(long amount) {
        if (canWithdraw(amount)) {
            this.ballance -= amount;
            return true;
        }
        return false;
    }

    public long getBallance() {
        return ballance;
    }

    public String getAccountOwnerName() {
        return client.getName();
    }

    public boolean transfer(Account target, long amount) {
        if (canWithdraw(amount)) {
            this.ballance -= amount;
            target.ballance += amount;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountOwnerName='" + client.getName() + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", ballance=" + ballance +
                '}' +
                "\n" + super.toString();
    }

    private boolean canWithdraw(long amount) {
        return amount >= this.ballance;
    }
}
