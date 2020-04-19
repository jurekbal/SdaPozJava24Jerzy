package zajecia13;

public class Printer implements Runnable {
    private int time;
    private String text;
    private int counter;
    private boolean isActive;

    public Printer(String text, int time) {
        this.text = text;
        this.time = time;
        this.isActive = true;
    }

    public void deactivate() {
        isActive = false;
    }

    @Override
    public void run() {
        while (isActive) {
            System.out.println(text + " " + counter);
            counter++;
            try {
                Thread.sleep(time);
            } catch (InterruptedException e){
                System.err.println("interrupted " + text + counter);
            }
        }

        System.out.println("Koniec pracy wątku: " + text);
    }
}
