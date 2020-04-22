package zajecia13.zuzel;

public class Rider implements Runnable {
    private static int numOfRiders = 0;

    private final String name;
    private final int startPositionNum;
    private final double maxSpeed; // m/s

    private double currentSpeed;
    private int currentLap = 1;
    private boolean finishPassed = false;
    private double positionOnTrack = 0;
    private int lastLapMillis = 0;
    private int totalRideMillis = 0;
    private final int TRACK_LENGTH = Track.TRACK_LENGTH;

    private final int TICK_MILLIS = 123; // czasookres oblcizeń
    private final double TICKS_PER_SECOND = 1000.0 / TICK_MILLIS;

    public Rider(String name, int maxSpeed) {
        this.name = name;
        this.startPositionNum = ++numOfRiders;
        this.maxSpeed = maxSpeed * 1000.0 / 3600.0; // jednostka parametru: km/h
        this.currentSpeed = this.maxSpeed; // jednostka pola: m/s
    }

    @Override
    public void run() {
        System.out.println(name + " (" + startPositionNum + ") rozpczął bieg.");

        while (!finishPassed) {
            sleepOneTick();
            updateTimesAndPosition();
            checkIfLapPassed();
        }
    }

    private void sleepOneTick() {
        try {
            Thread.sleep(TICK_MILLIS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void checkIfLapPassed() {
        if (positionOnTrack > TRACK_LENGTH) {
            System.out.println(name + " (" + startPositionNum + ") czas okrążenia nr " + currentLap + ": "
                    + (lastLapMillis / 1000.0) + "s");
            currentLap++;
            if (currentLap > 4) {
                finishPassed = true;
                System.out.println(name + " (" + startPositionNum + ") zakończył wyścig z czasem " +
                        (totalRideMillis / 1000.0) + "s" );
            }
            resetPositionAndLapTime();
        }
    }

    private void resetPositionAndLapTime() {
        // zerowanie pozycji po okrążeniu z uwaględnieniem odcinka przejechanego do czasu obliczeń
        positionOnTrack = positionOnTrack % TRACK_LENGTH;
        // zerowanie czasu okrążęnia z uwzględnieniem pozycji w momencie obliczeń
        lastLapMillis = (int) (currentSpeed / positionOnTrack);
    }

    private void updateTimesAndPosition() {
        lastLapMillis += TICK_MILLIS;
        totalRideMillis += TICK_MILLIS;
        positionOnTrack += currentSpeed / TICKS_PER_SECOND;
    }

}

