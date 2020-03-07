package zajecia10.bank;

public class CreditAccount extends Account {

    @Override
    public boolean withdraw(long amount) {
        super.ballance-= amount;
        return true;
    }

    public CreditAccount(Client client, String accountNumber, long initialBallance) {
        super(client, accountNumber, initialBallance);


    }
}
