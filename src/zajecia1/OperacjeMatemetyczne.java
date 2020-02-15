package zajecia1;

public class OperacjeMatemetyczne {

    public static void main(String[] args){

        String str1 = "To ";
        String str2 = "jest ";
        String str3 = "połączony ";
        String str4 = "łańcuch ";
        String str5 = "znaków.";
        String strAll = str1 + str2 + str3 + str4 + str5;

        System.out.println(strAll);

        int a = 25;
        int b = 10;

        int wynik = a + b;

        System.out.println(a+b);
        System.out.println(a-b);
        System.out.println(a*b);
        System.out.println(a/b); // wynik całkowity
        System.out.println(a%b);


    }

}
