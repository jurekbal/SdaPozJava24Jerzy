package zajecia10.bank;

public class NegativeWithdrawException extends Exception {

    public NegativeWithdrawException(String msg) {
        super(msg);
    }
}
