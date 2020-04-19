package zajecia12.zadania;

import java.util.List;
import java.util.Map;

public class StudentService {

    public double calculateAveratge(List<Integer> grades){
        double sum = 0;
        int numGrades = grades.size();
        for (Integer i : grades) {
            sum+= i;
        }

        return sum/numGrades;
    }

    public double calculateTotalAverage(Map<Student, List<Integer>> studentToGrades) {
        double sum =0;
        int numStudents = studentToGrades.size();
        for (List<Integer> gradeList : studentToGrades.values()) {
            sum+= calculateAveratge(gradeList);
        }

        return sum/numStudents;
    }

    public Student findBestStudent(Map<Student, List<Integer>> studentToGrades){
        Student bestStudent = null;
        double bestAverage = 0;
        for (Map.Entry<Student, List<Integer>> entry : studentToGrades.entrySet()) {
            double currentEntryAvg = calculateAveratge(entry.getValue());
            if (currentEntryAvg > bestAverage) {
                bestAverage = currentEntryAvg;
                bestStudent = entry.getKey();
            }
        }
        return bestStudent;
    }


}
