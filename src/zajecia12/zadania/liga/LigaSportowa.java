package zajecia12.zadania.liga;

import zajecia11.zaddom3z3.Liczebniki;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class LigaSportowa {
    private static Map<String, Wyniki> tabela = new HashMap<>();

    public static void main(String[] args) {

        //TODO read data from folder
        //String testLine = "LPO - LWA 3:1";
        //String[] line = parseLine(testLine);

        Path path = Paths.get("iofiles/liga/kolejka1.txt");

        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;

            while ((line = reader.readLine()) != null) {

                String[] lineArr = parseLine(line);
                addTeamIfNotExists(lineArr);
                aktualizujWyniki(lineArr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        printTable();
    }

    private static void printTable() {
        for (Map.Entry<String, Wyniki> linia : tabela.entrySet()) {
            System.out.println(linia.getKey() +
                    " punkty:" + linia.getValue().getPunkty() +
                    " Wygrane:" + linia.getValue().getWygrane() +
                    " Rremisy:" + linia.getValue().getRemisy() +
                    " Przegrane:" + linia.getValue().getPorazki() +
                    " Bramki Zdobyte:" + linia.getValue().getBramkiZdobyte() +
                    " Bramki Stracone:" + linia.getValue().getBramkiStracone());
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
