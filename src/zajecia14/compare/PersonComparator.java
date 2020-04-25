package zajecia14.compare;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
//        Person p1 = (Person) o1;
//        Person p2 = (Person) o2;
        return p1.getName().compareTo(p2.getName());
    }
}
