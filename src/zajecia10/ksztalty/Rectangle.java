package zajecia10.ksztalty;

public class Rectangle extends Polygon {
    private double edgeX;
    private double edgeY;


    public Rectangle(double edgeX, double edgeY) {
        this.edgeX = edgeX;
        this.edgeY = edgeY;
    }

    @Override
    public int getEdgesNum() {
        return 4;
    }

    @Override
    public double getArea() {
        return edgeX * edgeY;
    }

    @Override
    public double getPerimrter() {
        return 2 * (edgeX + edgeY);
    }
}
