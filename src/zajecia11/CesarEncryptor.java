package zajecia11;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CesarEncryptor {
    public static void main(String[] args) throws IOException {

        final int OFFSET = 5;

        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new FileReader("iofiles\\test.txt");
            outputStream = new FileWriter("iofiles\\encrypted_test.txt");

            int c;
            while ((c = inputStream.read()) != -1) {
                if (c >= 'A' && c <= 'Z') {
                    c = ((c - 65 + OFFSET) % 26) + 65;
                }
                if (c >= 'a' && c <= 'z') {
                    c = ((c - 97 + OFFSET) % 26) + 97;
                }
                outputStream.write(c);
            }
        } catch (IOException e) {
            System.err.println("Problem z plikiem: " + e.getMessage());
        } finally {
            if (inputStream != null) {
                inputStream.close();
                outputStream.close();
            }
        }

    }
}
