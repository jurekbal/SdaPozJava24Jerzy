package zajecia14.compare;

public class Person implements Comparable<Person> {

    private final int age;

    private final String name;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person theOther) {
        //Person theOther = (Person) o;
        return this.age - theOther.age;
    }

    @Override
    public String toString() {
        return name + "[" + age + "]";
    }
}
