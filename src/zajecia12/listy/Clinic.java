package zajecia12.listy;

import java.util.ArrayDeque;
import java.util.Queue;

public class Clinic {

    private Queue<Patient> queue = new ArrayDeque<>(); //LinkedList - bufor przesuwny na bazie tablicy

    public static void main(String[] args) {
        Clinic clinic = new Clinic();
        clinic.register("Zbyszek");
        clinic.register("Jarek");
        clinic.register("Grzegorz");
        clinic.handle();
        clinic.handle();
        clinic.handle();
        clinic.handle();
    }

    public void register(String name){
        queue.add(new Patient(name));
    }

    public Patient handle(){
        Patient toServe = queue.poll();
        System.out.println("Obsługuję: " + toServe);
        System.out.println("W kolejce zostaje: " + queue.size());
        return toServe;
    }

}
