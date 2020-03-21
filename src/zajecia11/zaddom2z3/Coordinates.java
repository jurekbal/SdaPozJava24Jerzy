package zajecia11.zaddom2z3;

public class Coordinates {
    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates() {
        this.x = 0;
        this.y = 0;
    }

    public void move(int x, int y){
        this.x += x;
        this.y += y;
    }

    public void print(){
        System.out.println("(x:y)=(" + x + ":" + y +")");
    }
}
