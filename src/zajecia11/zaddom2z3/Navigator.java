package zajecia11.zaddom2z3;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Navigator {
    public static void main(String[] args) throws IOException {

        Coordinates coordinates = new Coordinates();
        FileReader inputStream = null;

        try {
            inputStream = new FileReader("iofiles\\directions.txt");
            Scanner scanner = new Scanner(inputStream);

            String line;
            int x;
            int y;
            while (scanner.hasNext()) {
                line = scanner.nextLine().toUpperCase();
                try {
                    x = Direction.valueOf(line).x;
                    y = Direction.valueOf(line).y;
                    coordinates.move(x, y);
                    System.out.print(line);
                    System.out.print(" ");
                    coordinates.print();
                } catch (IllegalArgumentException e) {}
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }
}
