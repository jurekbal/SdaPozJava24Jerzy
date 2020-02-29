package zajecia8;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class DateTimeIleMinelo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.print("Podaj datę w formacie yyyy-mm-dd:");
        String dataString = scanner.nextLine();

        LocalDate data = LocalDate.parse(dataString, format);
        LocalDate dzis = LocalDate.now();

        Period period = Period.between(data, dzis);

        System.out.println("Mineło " + period.getYears() + " lat " + period.getMonths() + " miesięcy " +
                period.getDays() + " dni");



    }
}
