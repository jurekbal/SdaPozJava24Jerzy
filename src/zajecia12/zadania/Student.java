package zajecia12.zadania;

public class Student {
    private String firstName;
    private String LastName;
    private String mainLanguage;

    public Student(String firstName, String lastName, String mainLanguage) {
        this.firstName = firstName;
        LastName = lastName;
        this.mainLanguage = mainLanguage;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getMainLanguage() {
        return mainLanguage;
    }
}
