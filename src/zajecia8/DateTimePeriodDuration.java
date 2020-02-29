package zajecia8;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;

public class DateTimePeriodDuration {
    public static void main(String[] args) {

        LocalDateTime now1 = LocalDateTime.now();
        LocalDateTime myBirthday = LocalDateTime.of(1980, 5,12,19,55, 0);
        LocalDateTime myFathersBirthday = LocalDateTime.of(1960,11,9, 7,55,14);

        Duration duration = Duration.between(myFathersBirthday, myBirthday);
        System.out.println(duration.getSeconds());

        Period period = Period.between(myFathersBirthday.toLocalDate(), myBirthday.toLocalDate());
        System.out.println(period.getYears() + "Y " + period.getMonths() + "M " + period.getDays() + "D");


        LocalDateTime now2 = LocalDateTime.now();
        duration = Duration.between(now2, now1);
        System.out.println(duration.getNano());

        now1 = LocalDateTime.now();
        int a = 123;
        String s = "Just string for delay";
        System.out.println("int:"+a);
        System.out.println(s);
        now2 = LocalDateTime.now();
        duration = Duration.between(now2, now1);
        System.out.println(duration.getNano());


    }

}
