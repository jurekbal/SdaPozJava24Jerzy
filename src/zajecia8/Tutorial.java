package zajecia8;

import java.util.Scanner;

public class Tutorial {
    //https://www3.ntu.edu.sg/home/ehchua/programming/java/J2a_BasicsExercises.html#zz-9.2
    //Ex9.2  PrintArrayInStars (Array)
    // by Asia
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ile wariantów chcesz podać? ");
        int n = scanner.nextInt();
        System.out.println("Podaj " + n + " liczb oddzielonych spacją: ");
        int[] item = new int[n];
        for (int i = 0; i < item.length; i++) {  // row
            item[i] = scanner.nextInt();
            System.out.println(" ");
            System.out.print(i+1 + ": ");
            // Print value as the number of stars
            for (int starNo = 1; starNo <= item[i]; starNo++) {  // column
                System.out.print("*");
            }
            System.out.println("[" + item[i] + "]");
        }
    }
}
