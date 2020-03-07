package zajecia10.bank;

public class PersonalClient extends Client {
    private String firstName;
    private String secondName;

    public PersonalClient(String name, String postalAdress, String email) {
        super(name, postalAdress, email);
    }

    public PersonalClient(String firstName, String secondName) {
        super(firstName + secondName, null, null);
        this.firstName = firstName;
        this.secondName = secondName;
    }
}
