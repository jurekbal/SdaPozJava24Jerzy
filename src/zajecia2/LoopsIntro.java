package zajecia2;

public class LoopsIntro {
    public static void main(String[] args) {
        int i = 0;
        while (i<50){
            System.out.println(i);
            i = i + 7;
        }

        // 2 sposób na i = i + 7
        i = 0;
        while (i<50) {
            System.out.println(i);
            i += 7;
        }

        // 3 sposób - tylko dla zwiększania o 1;
        i = 0;
        while (i<7) {
            System.out.println(i);
            i++;
        }

        // pre- i post- inkrementacja
        int liczba = 0;
        System.out.println("Pre vs post inkrementacja");
        System.out.println("Postinkrementacja");
        System.out.println(liczba++);  // 0
        System.out.println(liczba);    // 1

        liczba = 0;
        System.out.println("Preinkrementacja");
        System.out.println(++liczba);    //1
        System.out.println(liczba);     // 1

        System.out.println("Postinkrementacja - pętla while");
        i = 0;
        while (i < 10){
            System.out.println(i++);
        }

        System.out.println("Preinkrementacja - pętla while");
        i = 0;
        while (i < 10){
            System.out.println(++i);
        }

        System.out.println("Pętla do while"); //pętla do while wykona się przynajmniej raz
        i = 20;
        do {
            System.out.print(i++);
            System.out.print(", ");
        } while (i < 10);
    }
}
