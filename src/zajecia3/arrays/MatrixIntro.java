package zajecia3.arrays;

// faktycznie klasa powstała na zajeciach 3

public class MatrixIntro {
    public static void main(String[] args) {

        int[][] macierz = new int[3][10]; //[wierszey][kolumn]; [y-ów][x-ów]

        System.out.println(macierz.length); // liczba wierszy (y-ów)
        System.out.println(macierz[0].length); // liczba kolumn (x-ów)

        for (int i = 0; i < macierz.length; i++) {
            for (int j = 0; j < macierz[0].length; j++) {
                System.out.print(macierz[i][j]);
            }
            System.out.println(); //po wypisaniu wiersza prtln
            
        }
    }
}
