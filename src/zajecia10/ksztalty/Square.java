package zajecia10.ksztalty;

public class Square extends Rectangle {
    @Override
    public int getEdgesNum() {
        return super.getEdgesNum();
    }

    // nie potrzeba poniższyc metod bo i tak są dziedziczone z klasy Rectangle

//    @Override
//    public double getArea() {
//        return super.getArea();
//    }
//
//
//    @Override
//    public double getPerimrter() {
//        return super.getPerimrter();
//    }

    public Square(double edge) {
        super(edge, edge);


    }
}
