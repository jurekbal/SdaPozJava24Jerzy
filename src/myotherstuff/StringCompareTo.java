package myotherstuff;

public class StringCompareTo {
    public static void main(String[] args) {
        String[] names = {"Nowak", "Nowicki", "Adamski", "b", "Modalski", "Zygalski", "aaa","Acimski"};

        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("Sorting...");
        String temp;
        for(int a=0;a<names.length;a++) {
            for(int b=a+1;b<names.length;b++) {
                if( names[a].toUpperCase().compareTo(names[b].toUpperCase()) > 0 ) {
                    temp = names[a];
                    names[a] = names[b];
                    names[b] = temp;
                }
            }
        }
        for (String name : names) {
            System.out.println(name);
        }
    }
}
