package zajecia8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateTimeLocalDateTime {
    public static void main(String[] args) {

        LocalDateTime localDateTime1 = LocalDateTime.of(2019, 1, 2, 12, 15 ,20, 1234556);

        LocalDate date = LocalDate.of(1983,3,15);
        LocalTime time = LocalTime.of(14,30,15);
        LocalDateTime lDT = LocalDateTime.of(date, time);
        System.out.println(lDT);

        System.out.println(localDateTime1.getDayOfWeek());
        System.out.println(localDateTime1.getDayOfYear());
        System.out.println(lDT.getMonth());
        System.out.println(lDT.getMonthValue());
    }
}
