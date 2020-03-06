package zajecia6.listaPracownikow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


/**
 * Pierwsze testowe wykorzystanie odczytu i zapisu do pliku
 */
public class IOPlayground {
    public static void main(String[] args) {

        Path path = Paths.get("G:\\Kursy\\javafiles", "text.txt");

        try (BufferedReader czytnik = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {

            String linia;
            while ((linia = czytnik.readLine()) != null) {
                System.out.println(linia);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND)) {
            writer.write("Nowa linia tekstu\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
