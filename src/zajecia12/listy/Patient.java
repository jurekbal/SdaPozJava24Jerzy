package zajecia12.listy;

public class Patient {
    private final String name;

    public Patient(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
