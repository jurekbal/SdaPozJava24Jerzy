package zajecia12.zadania;

public class Student {
    private String firstName;
    private String lastName;
    private String mainLanguage;

    public Student(String firstName, String lastName, String mainLanguage) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mainLanguage = mainLanguage;
    }

    @Override
    public String toString() {
        return firstName + " " +
                lastName + " " +
                mainLanguage;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMainLanguage() {
        return mainLanguage;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Student)) {
            return false;
        }
        Student theOther = (Student)obj;
        if (
                (theOther.mainLanguage.equals(this.mainLanguage)) &&
                (theOther.lastName.equals(this.lastName)) &&
                (theOther.firstName.equals(this.firstName))
        ) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return lastName.hashCode();
    }
}
