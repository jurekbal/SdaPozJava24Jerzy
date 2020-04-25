package zajecia14.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Class {

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Adam", 20));
        list.add(new Person("Ania", 22));
        list.add(new Person("Alex", 24));
        list.add(new Person("Bartosz", 18));
        list.add(new Person("Bogdan", 25));
        list.add(new Person("Aleksandra", 28));

        // uzycie interfejsu Comparable (metoda compareTo)
        System.out.println(list.toString());
        Collections.sort(list); //in situ
        System.out.println(list.toString());

        // użycie interfejsu Comparator (metoda compare)
        list.sort(new PersonComparator());
        System.out.println(list.toString());

        // analogicznie przy pomocy klasy anonimowej
        list.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Person p1 = (Person) o1;
                Person p2 = (Person) o2;
                return p2.getName().compareTo(p1.getName()); // tu zmineiliśmy kierunek sortowania for fun
            }
        }); // klasy anonimowe są praktyczne gdy impementujemy interfejsy jednometodowe (np. Comparator)
        System.out.println(list.toString());

    }
}
