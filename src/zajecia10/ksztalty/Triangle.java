package zajecia10.ksztalty;

public class Triangle extends Polygon {
    private double baseA;
    private double baseB;
    private double baseC;
    private double heightA;

    public Triangle(double baseA, double baseB, double baseC ,double heightA) {
        this.baseA = baseA;
        this.baseB = baseB;
        this.baseC = baseC;
        this.heightA = heightA;
    }

    @Override
    public int getEdgesNum() {
        return 3;
    }

    @Override
    public double getArea() {
        return 0.5 * baseA * heightA;
    }

    @Override
    public double getPerimrter() {
        return baseA + baseB + baseC;
    }
}
