package zajecia7.zadaniaDomowe;

import java.util.Scanner;

// Zadania do domu_weekend_1.pdf - zad 7
public class Spammer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String slowo;
        int liczbaPowtorzen;

        do {
            System.out.print("Podaj słowo:");
            slowo = scanner.nextLine();
            if (slowo.equals("")) {
                break;
            }
            System.out.print("Podaj liczbę powtórzeń:");
            if (scanner.hasNextInt()) {
                liczbaPowtorzen = scanner.nextInt();
                scanner.nextLine();
            } else {
                liczbaPowtorzen = 0;
            }
            drukuj(slowo,liczbaPowtorzen);
        } while (true);
    }

    public static void drukuj(String slowo, int liczbaPowtorzen){
        for (int i = 0; i < liczbaPowtorzen; i++) {
            System.out.println(slowo);
        }
    }
}
