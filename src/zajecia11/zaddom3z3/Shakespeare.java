package zajecia11.zaddom3z3;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

// zlicza liczebniki słowne z dzieła Szekspira
public class Shakespeare {
    public static void main(String[] args) {

        String regex = "[\\s.,:;-]+"; // lub [ .,:;]+ dzieli na wyrazy
        // Path path = Paths.get("iofiles\\shake_frag.txt");
        Path path = Paths.get("G:\\Kursy\\javafiles\\t8.shakespeare.txt");

        int[] iloscLiczebnikow = new int[13];

        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {

            String linia;
            while ((linia = reader.readLine()) != null) {
                //System.out.println(linia);

                String[] wyrazy = linia.split(regex);
                for (String slowo : wyrazy) {
                    //System.out.print(slowo + "*");
                    try {
                        Liczebniki l = Liczebniki.valueOf(slowo.toUpperCase());
                        iloscLiczebnikow[l.ordinal()]++;
                    } catch (IllegalArgumentException e) { }
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Liczebniki[] liczebniki = Liczebniki.values();
        for (int i = 0 ; i < iloscLiczebnikow.length; i ++) {
            System.out.println(liczebniki[i].name() + " " + iloscLiczebnikow[i]);

        }
    }
}
