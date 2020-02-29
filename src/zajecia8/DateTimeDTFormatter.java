package zajecia8;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTimeDTFormatter {
    public static void main(String[] args) {

        LocalDate ld = LocalDate.of(2018,6,22);

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.YYYY");

        String tekst = ld.format(format);
        System.out.println(ld);
        System.out.println(tekst);

        String mojaData = "2020 11 15";
        format = DateTimeFormatter.ofPattern("yyyy MM dd");
        LocalDate mojaLocalDate = LocalDate.parse(mojaData, format);
    }
}
