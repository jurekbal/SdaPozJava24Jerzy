package zajecia5.prostokat;

import java.util.Scanner;

public class ProstokatProgram {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Podaj bok A prostokąta nr 1:");
        int a = sc.nextInt();
        System.out.print("Podaj bok B prostokąta nr 1:");
        int b = sc.nextInt();
        Prostokat pr1 = new Prostokat(a, b);

        System.out.print("Podaj bok A prostokąta nr 2:");
        a = sc.nextInt();
        System.out.print("Podaj bok B prostokąta nr 2:");
        b = sc.nextInt();
        Prostokat pr2 = new Prostokat(a, b);

        System.out.print("Podaj bok A prostokąta nr 3:");
        a = sc.nextInt();
        System.out.print("Podaj bok B prostokąta nr 3:");
        b = sc.nextInt();
        Prostokat pr3 = new Prostokat(a, b);

        System.out.println("Prostokąt 1: A=" + pr1.getBokA() + " B=" + pr1.getBokB() + " pole=" + pr1.pole() + " obwód=" + pr1.obwod());
        System.out.println("Prostokąt 2: A=" + pr2.getBokA() + " B=" + pr2.getBokB() + " pole=" + pr2.pole() + " obwód=" + pr2.obwod());
        System.out.println("Prostokąt 3: A=" + pr3.getBokA() + " B=" + pr3.getBokB() + " pole=" + pr3.pole() + " obwód=" + pr3.obwod());
    }
}
