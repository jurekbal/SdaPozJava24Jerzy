package zajecia12.zadania.liga;

import java.util.HashMap;
import java.util.Map;

public class LigaSportowa {
    private static Map<String, Wyniki> tabela = new HashMap<>();

    public static void main(String[] args) {
        //TODO read data from files
        String testLine = "LPO - LWA 3:1";
        String[] line = parseLine(testLine);

        addTeamIfNotExists(line);
        aktualizujWyniki(line);
        printTable();

    }

    private static void printTable() {
        for (Map.Entry<String, Wyniki> linia : tabela.entrySet()) {
            System.out.println(linia.getKey() +
                    " pkt:" + linia.getValue().getPunkty() +
                    " W:" + linia.getValue().getWygrane() +
                    " R:" + linia.getValue().getRemisy() +
                    " P:" + linia.getValue().getPorazki() +
                    " BrZd:" + linia.getValue().getBramkiZdobyte() +
                    " BrStr:" + linia.getValue().getBramkiStracone());
        }
    }

    private static void addTeamIfNotExists(String[] line) {
        if (!tabela.containsKey(line[0])) {
            tabela.put(line[0], new Wyniki());
        }
        if (!tabela.containsKey(line[1])) {
            tabela.put(line[1], new Wyniki());
        }
    }

    private static void aktualizujWyniki(String[] line) {
        Wyniki w1 = tabela.get(line[0]);
        Wyniki w2 = tabela.get(line[1]);
        int gole1 = Integer.parseInt(line[2]);
        int gole2 = Integer.parseInt(line[3]);
        w1.setBramkiZdobyte(gole1);
        w1.setBramkiStracone(gole2);
        if (gole1 > gole2) {
            w1.setWygrane(w1.getWygrane() + 1);
            w2.setPorazki(w2.getPorazki() + 1);
        } else if (gole1 < gole2) {
            w1.setPorazki(w1.getPorazki() + 1);
            w2.setWygrane(w2.getWygrane() + 1);
        } else {
            w1.setRemisy(w1.getRemisy() + 1);
            w2.setRemisy(w2.getRemisy() + 1);
        }
    }

    private static String[] parseLine(String line) {
        return line.split("\\W+");
    }
}
