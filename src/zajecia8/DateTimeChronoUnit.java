package zajecia8;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class DateTimeChronoUnit {
    public static void main(String[] args) {

        LocalDateTime myBirthday = LocalDateTime.of(1980, 5,12,19,55, 0);
        LocalDateTime myFathersBirthday = LocalDateTime.of(1960,11,9, 7,55,14);

        System.out.println(ChronoUnit.YEARS.between(myFathersBirthday, myBirthday));
        System.out.println(ChronoUnit.MONTHS.between(myFathersBirthday, myBirthday));
        System.out.println(ChronoUnit.DAYS.between(myFathersBirthday, myBirthday));
        System.out.println(ChronoUnit.HOURS.between(myFathersBirthday, myBirthday));
        System.out.println(ChronoUnit.MINUTES.between(myFathersBirthday, myBirthday));
        System.out.println(ChronoUnit.SECONDS.between(myFathersBirthday, myBirthday));
        System.out.println(ChronoUnit.MILLIS.between(myFathersBirthday, myBirthday));
        System.out.println(ChronoUnit.NANOS.between(myFathersBirthday, myBirthday));

        LocalTime tm1 = LocalTime.now();
        LocalTime tm2 = LocalTime.now();
        System.out.println(ChronoUnit.NANOS.between(tm2,tm1));

    }
}
