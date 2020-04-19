package zajecia13;

import java.time.LocalTime;

public class Worker implements Runnable {
    private boolean isActive;
    private String name;
    private int reportDuration;

    public Worker(String name, int reportDuration) {
        this.isActive = true;
        this.name = name;
        this.reportDuration = reportDuration;
    }

    public int getReportDuration() {
        return reportDuration;
    }

    public void setReportDuration(int reportDuration) {
        this.reportDuration = reportDuration;
    }

    @Override
    public void run() {
        System.out.println(name + " rozpoczął pracę o " + LocalTime.now());
        while (isActive) {
            try {
                Thread.sleep(reportDuration);
            } catch (InterruptedException e) {

            }
            System.out.println(name + " nadal pracuje...");
        }
        System.out.println(name + " kończy prace");
    }

    public void deactivate(){
        isActive = false;
    }

    public boolean isActive() {
        return isActive;
    }
}
