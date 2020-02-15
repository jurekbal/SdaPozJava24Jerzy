package zajecia5.prostokat;

public class Prostokat {
    private int bokA;
    private int bokB;
    // publiczne pola to zło, praktycznie zawsze pola są prywantne;
    // nie mamy kontroli nad przypisywaniem danych do takiego pola z zewnątrz
    // dostęp robi się przez metody getter i setter


    public Prostokat(int bokA, int bokB){
        this.bokA = bokA;
        this.bokB = bokB;
    }

    public int pole(){
        return bokA * bokB;
    }

    public int obwod(){
        return 2 * bokA + 2 * bokB;
    }

    // getter i setter

    //metoda gettera
    public int getBokA(){
        return this.bokA;
    }

    // metoda settera
    public void setBokA(int bokA){
        this.bokA = bokA;
    }

    public int getBokB() {
        return bokB;
    }

    public void setBokB(int bokB) {
        this.bokB = bokB;
    }
}
