package zajecia12.zadania;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//zad dom 1
public class StudentMain {
    public static void main(String[] args) {
        Map<Student, List<Integer>> mapaStudentow = new HashMap<>();
        
        Student janKowalski = new Student("Jan", "Kowalski", "PL");
        Student stanislawNowak = new Student("Stanisław", "Nowak", "PL");
        Student arminVanDuren = new Student("Armin", "van Duren", "NL");
        
        
        mapaStudentow.put(janKowalski, new ArrayList<>() );
        mapaStudentow.get(janKowalski).add(2);
        mapaStudentow.get(janKowalski).add(4);
        mapaStudentow.get(janKowalski).add(3);
        mapaStudentow.get(janKowalski).add(4);
        mapaStudentow.get(janKowalski).add(5);
        mapaStudentow.get(janKowalski).add(3);

        mapaStudentow.put(stanislawNowak, new ArrayList<>() );
        mapaStudentow.get(stanislawNowak).add(4);
        mapaStudentow.get(stanislawNowak).add(5);
        mapaStudentow.get(stanislawNowak).add(4);
        mapaStudentow.get(stanislawNowak).add(3);
        mapaStudentow.get(stanislawNowak).add(4);
        mapaStudentow.get(stanislawNowak).add(3);

        mapaStudentow.put(arminVanDuren, new ArrayList<>() );
        mapaStudentow.get(arminVanDuren).add(2);
        mapaStudentow.get(arminVanDuren).add(2);
        mapaStudentow.get(arminVanDuren).add(3);
        mapaStudentow.get(arminVanDuren).add(3);
        mapaStudentow.get(arminVanDuren).add(3);
        mapaStudentow.get(arminVanDuren).add(2);
        
        for (Map.Entry<Student, List<Integer>> student : mapaStudentow.entrySet()) {
            System.out.print(student.getKey().getFirstName() +" "+ student.getKey().getLastName() + " " +
                    student.getKey().getMainLanguage() + " Oceny: " );
            for (Integer ocena : student.getValue()) {
                System.out.print(ocena + " ");
            }
            System.out.println();
        }
        
    }

}
