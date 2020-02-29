package zajecia8;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.TimeZone;

public class DateTimeZonedDateTime {
    public static void main(String[] args) {

        String[] ids = TimeZone.getAvailableIDs();
        System.out.println(Arrays.toString(ids));

        ZoneId newYork = ZoneId.of("America/New_York");

        System.out.println(ZonedDateTime.now());
        System.out.println(ZonedDateTime.now(newYork));
    }
}
