package zajecia6;

public class Alfabet {
    // Zamiana znaków na odpowiadające im kody

    public static void main(String[] args) {

        String napis = "Java";

        System.out.println("\"" + napis + "\" w kodach to:");

        for (int i = 0; i < napis.length(); i++) {
            System.out.print( (int) napis.charAt(i) + " ");
        }

        // int kod = napis.charAt(i) - też działa, ale nie w sout, bo on oczekuje wtedy char

    }

}
