package zajecia10.bank;

public class Bank {
    private String name;
    private String iban;
    private Account[] accounts;
    private Client[] clients;

    public Bank(String name, String iban) {
        this.name = name;
        this.iban = iban;
    }

    public static void main(String[] args) {
        Bank bank = new Bank("Super Bank", "PLXBSB");

        Client persCli01 = new PersonalClient("Jacek", "Nowicki" );
        Client bsCli01 = new BusinessClient("Acme");  // Client -> BussinesClient
        if (bsCli01 instanceof BusinessClient) {
            System.out.println("biznesowy");
            System.out.println("NIP: " + ((BusinessClient) bsCli01).getNip()); //rzutowanie obiektu Client na BussinesClient (tu musi być)
        }

        Account account01 = new CreditAccount(persCli01, "1234", 500);
        Account account02 = new CheckingAccount(bsCli01, "4321", 200);
        Account account03 = new CreditAccount(bsCli01,"6789", 700);

        System.out.println(account01);
        System.out.println(account02);
        System.out.println(account03);
        System.out.println(persCli01);

        System.out.println("************************************");
        System.out.println("account02 ballance before transfer: " + account02.getBallance());
        try {
            //account01.withdraw(-5);
            //account02.withdraw(1000);
            //account01.transfer(account02, -4);
            account01.transfer(account02, 1000);
            //account01.transfer(account02, 350);
        } catch (InsufficientBalanceException | NegativeWithdrawException e) {
            System.out.println("Błąd: " + e.getMessage());
            //e.printStackTrace();
        } finally {
            System.out.println("account02 ballance after transfer: " + account02.getBallance());
        }

    }
}
