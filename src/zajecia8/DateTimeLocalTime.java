package zajecia8;

import java.time.LocalTime;

public class DateTimeLocalTime {
    public static void main(String[] args) {

        LocalTime now = LocalTime.now();
        System.out.println(now);

        LocalTime meeting = LocalTime.of(11,30,0);
        System.out.println(meeting);

        LocalTime meetingFinish = meeting.plusHours(3);
        System.out.println(meetingFinish);

        System.out.println(meetingFinish.isAfter(meeting));
    }
}
