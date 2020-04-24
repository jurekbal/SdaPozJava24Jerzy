package zajecia13.zuzel;

import java.util.ArrayList;
import java.util.List;

public class Track {
    public static final int TRACK_LENGTH = 370; // m
    public static List<Rider> riders;

    public static void main(String[] args) {
        riders = new ArrayList<>();

        riders.add(new Rider("Gollob", 140));
        riders.add(new Rider("Czaja", 45));
        riders.add(new Rider("Gomólski", 101));
        riders.add(new Rider("Lampart", 68));

        for (Rider rider : riders) {
            Thread thread = new Thread(rider);
            thread.start();
        }
    }
}
