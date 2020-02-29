package zajecia8;

import java.time.LocalDate;
import java.time.Month;

public class DateTimeLocalDate {
    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        System.out.println("Dziasiaj: " + today + " " + today.getDayOfWeek());

        LocalDate specialDay = LocalDate.of(2022, 3,11);
        LocalDate specialDay2 = LocalDate.of(2022, Month.JUNE, 23);

        String myBirthday = "1882-04-28";
        LocalDate myBirthdayLocalDate = LocalDate.parse(myBirthday);
        System.out.println("My birthday: " + myBirthdayLocalDate);

        LocalDate tomorrow = LocalDate.now().plusDays(1);
        System.out.println("Jutro: " + tomorrow);
    }
}
