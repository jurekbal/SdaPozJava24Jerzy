package zajecia12.zadania;

import java.util.*;

//zad dom 1
public class StudentMain {
    public static void main(String[] args) {
        Map<Student, List<Integer>> mapaStudentow = new HashMap<>();
        
        Student janKowalski = new Student("Jan", "Kowalski", "PL");
        Student stanislawNowak = new Student("Stanisław", "Nowak", "PL");
        Student ferminaDaza = new Student("Fermina", "Daza", "ES");
        
        
        mapaStudentow.put(janKowalski, new ArrayList<>(Arrays.asList(2,4,3,4,5,3)) );
//        mapaStudentow.get(janKowalski).add(2);
//        mapaStudentow.get(janKowalski).add(4);
//        mapaStudentow.get(janKowalski).add(3);
//        mapaStudentow.get(janKowalski).add(4);
//        mapaStudentow.get(janKowalski).add(5);
//        mapaStudentow.get(janKowalski).add(3);
        mapaStudentow.put(stanislawNowak, new ArrayList<>(Arrays.asList(4,5,4,3,5,3)) );
        mapaStudentow.put(ferminaDaza, new ArrayList<>(Arrays.asList(2,2,3,3,3,2)) );
        
        for (Map.Entry<Student, List<Integer>> student : mapaStudentow.entrySet()) {
            System.out.print(student.getKey().getFirstName() +" "+ student.getKey().getLastName() + " " +
                    student.getKey().getMainLanguage() + " Oceny: " );
            for (Integer ocena : student.getValue()) {
                System.out.print(ocena + " ");
            }
            System.out.println();
            System.out.println(student.toString());


        }
        StudentService studentService = new StudentService();
        System.out.println("Average of Kowalski:" + studentService.calculateAveratge(mapaStudentow.get(janKowalski)));
        System.out.println("Average of all students: " + studentService.calculateTotalAverage(mapaStudentow));
        Student bestStudent = studentService.findBestStudent(mapaStudentow);
        System.out.println("Best student : avg: " + bestStudent.toString() + " : " +
                studentService.calculateAveratge(mapaStudentow.get(bestStudent))
        );

        Student test = new Student("Jan", "Kowalski", "PL");
        System.out.println();
        
    }

}
