package zajecia10.bank;

public class Client {
    private String Name;
    private String postalAdress;
    private String email;

    public Client(String name, String postalAdress, String email) {
        Name = name;
        this.postalAdress = postalAdress;
        this.email = email;
    }

    public String getName() {
        return Name;
    }
}
