package zajecia11;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {
    public static void main(String[] args) {
        int userInteger = getUserInput();

        System.out.println("Super! Twoja liczba to: " + userInteger);
    }

    private static int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        int userInput;
        try {
            System.out.print("Podaj liczbę całkoiwtą:");
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Podano błędną wartość liczbową!");
            return getUserInput();
        } finally {
            scanner.close();
        }
    };
}
