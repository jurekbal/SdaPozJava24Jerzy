package zajecia8;

// Zad 4.6 ze strony https://www3.ntu.edu.sg/home/ehchua/programming/java/J2a_BasicsExercises.html
public class Fibo {
    public static void main(String[] args) {
        int n = 3;
        int fn;
        int fn1 = 1;
        int fn2 = 1;
        int nMax = 20;
        int sum = fn1 + fn2;
        double average;

        System.out.println("The first " + nMax + " Fibonacci numbers are:");
        System.out.print("1 1 ");
        while (n <= nMax) {
            fn = fn2 + fn1;
            sum+= fn;
            System.out.print(fn + " ");
            fn2 = fn1;
            fn1 = fn;
            n++;
        }
        average = sum / (double) nMax;
        System.out.println();
        System.out.println("The average is " + average);


    }
}
