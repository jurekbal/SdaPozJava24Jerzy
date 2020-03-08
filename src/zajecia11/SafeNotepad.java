package zajecia11;

import java.io.*;

public class SafeNotepad {
    public static void main(String[] args) throws IOException {

        FileReader inputStream = null;

        try {
            inputStream = new FileReader("test.txt");

            //System.out.println(new File(".").getCanonicalFile());

            int c;
            while ((c = inputStream.read()) != -1) {
                System.out.print((char)c);
            }
        } catch (IOException e) {
            System.err.println("Problem z plikiem: " + e.getMessage());
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }

    }
}
