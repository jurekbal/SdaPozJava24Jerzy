package zajecia13.zuzel;

public class Rider implements Runnable {
    private static int numOfRiders = 0;

    private final String name;
    private final int riderNumber; // nr zawodnika na torze
    private final double maxSpeed; // m/s

    private double currentSpeed;
    private int currentLap = 1;
    private int lastLap = 1;
    private boolean finishPassed = false;
    private double currentPositionOnTrack = 0;
    private double lastPositionOnTrack = 0;
    //private double totalDistance = 0;
    private int lastLapMillis = 0;
    private int totalRideMillis = 0;
    private final int TRACK_LENGTH = Track.TRACK_LENGTH;

    private final int TICK_MILLIS = 123; // czasookres oblcizeń
    private final double TICKS_PER_SECOND = 1000.0 / TICK_MILLIS;

    public Rider(String name, int maxSpeed) {
        this.name = name;
        this.riderNumber = ++numOfRiders;
        this.maxSpeed = maxSpeed * 1000.0 / 3600.0; // jednostka parametru: km/h
        this.currentSpeed = this.maxSpeed; // jednostka pola: m/s
    }

    @Override
    public void run() {
        System.out.println(name + " (" + riderNumber + ") rozpczął bieg.");

        while (!finishPassed) {
            sleepOneTick();
            updateTimesAndPosition();
            checkIfOvertaken();

            checkIfLapPassed();
        }

    }

    private void checkIfOvertaken() {
        //TODO poprawić, zmienić algorytm, bo nie wykrywa dublowania w każdym przypadku - najlepiej zmienić
        //TODO algo na zupełnie inny!
        //TODO + obsługa sytuacji, gdy riderzy mijają się w momencie przekraczania linii okrążenia
        for (Rider rival : Track.riders) {
            if (rival.getRiderNumber() != riderNumber ) { // check if not me
                if (checkPositionPasss(rival)) {
                    if (rival.getCurrentLap() == rival.getLastLap()) {
                        // tu jest minięcie bez przekroczenia mety
                        if (amILapAhead(rival)) {
                            System.out.println(name + " zdublował " + rival.name);
                        }
                    }
                }
            }
        }
    }

    private boolean amILapAhead(Rider rival) {
        return currentLap > rival.getCurrentLap();
    }

    private boolean checkPositionPasss(Rider rival) {
        return lastPositionOnTrack < rival.getLastPositionOnTrack()
                && currentPositionOnTrack > rival.getCurrentPositionOnTrack();
    }

    private void sleepOneTick() {
        try {
            Thread.sleep(TICK_MILLIS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void checkIfLapPassed() {
        if (currentPositionOnTrack > TRACK_LENGTH) {
            System.out.println("["+riderNumber+"] " + name + ": czas okrążenia nr " + currentLap + ": "
                    + (lastLapMillis / 1000.0) + "s");
            lastLap = currentLap++;
            if (currentLap > 4) {
                finishPassed = true;
                System.out.println("["+riderNumber+"] " + name + ": zakończył wyścig z czasem " +
                        (totalRideMillis / 1000.0) + "s" );
            }
            resetPositionAndLapTime();
        }
    }

    private void resetPositionAndLapTime() {
        // zerowanie pozycji po okrążeniu z uwaględnieniem odcinka przejechanego do czasu obliczeń
        currentPositionOnTrack = currentPositionOnTrack % TRACK_LENGTH;
        // zerowanie czasu okrążęnia z uwzględnieniem pozycji w momencie obliczeń
        lastLapMillis = (int) (currentSpeed / currentPositionOnTrack);
    }

    private void updateTimesAndPosition() {
        lastLapMillis += TICK_MILLIS;
        totalRideMillis += TICK_MILLIS;
        lastPositionOnTrack = currentPositionOnTrack;
        double positionDelta = currentSpeed / TICKS_PER_SECOND;
        currentPositionOnTrack += positionDelta;
        //totalDistance += positionDelta;
    }

    public int getRiderNumber() {
        return riderNumber;
    }

    public int getCurrentLap() {
        return currentLap;
    }

    public int getLastLap() {
        return lastLap;
    }

    public double getCurrentPositionOnTrack() {
        return currentPositionOnTrack;
    }

    public double getLastPositionOnTrack() {
        return lastPositionOnTrack;
    }
}

